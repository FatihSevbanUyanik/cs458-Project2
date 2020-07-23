package com.project458.myapplication.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.firestore.FirebaseFirestore;
import com.project458.myapplication.R;
import com.project458.myapplication.model.Answer;
import com.project458.myapplication.service.InterfaceData;
import com.project458.myapplication.service.ServiceAnswers;
import com.project458.myapplication.utils.FragmentManagement;
import com.project458.myapplication.utils.Util;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;

public class FragmentPoll extends Fragment implements InterfaceData {

    // UI elements
    @BindView(R.id.tvErrorNameSurname) TextView tvErrorNameSurname;
    @BindView(R.id.tvErrorBirthDate) TextView tvErrorBirthDate;
    @BindView(R.id.tvErrorGender) TextView tvErrorGender;
    @BindView(R.id.tvErrorCity) TextView tvErrorCity;
    @BindView(R.id.tvErrorText) TextView tvErrorText;
    @BindView(R.id.etNameSurname) EditText etNameSurname;
    @BindView(R.id.etBirthDate) EditText etBirthDate;
    @BindView(R.id.radioButtonMale) RadioButton radioButtonMale;
    @BindView(R.id.radioButtonFemale) RadioButton radioButtonFemale;
    @BindView(R.id.radioGroupGender) RadioGroup radioGroupGender;
    @BindView(R.id.etCity) AutoCompleteTextView etCity;
    @BindView(R.id.etText) EditText etText;
    @BindView(R.id.btnProceed) Button btnSend;

    // properties
    private String[] cities;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootLayout = inflater.inflate(R.layout.fragment_poll, container, false);
        ButterKnife.bind(this, rootLayout);
        return rootLayout;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        radioButtonFemale.setOnCheckedChangeListener((buttonView, isChecked) -> validateSendButton());
        radioButtonMale.setOnCheckedChangeListener((buttonView, isChecked) -> validateSendButton());
        cities = getResources().getStringArray(R.array.cities);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Objects.requireNonNull(getContext()),
                android.R.layout.simple_list_item_1, cities);
        etCity.setAdapter(adapter);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { validateSendButton(); }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
        };

        etNameSurname.addTextChangedListener(textWatcher);
        etBirthDate.addTextChangedListener(textWatcher);
        etText.addTextChangedListener(textWatcher);
        etCity.addTextChangedListener(textWatcher);
    }


    @OnFocusChange({R.id.etBirthDate})
    public void validateBirthDate(View v, boolean hasFocus) {
        if (hasFocus) return;
        String birthDate = etBirthDate.getText().toString();

        if (birthDate.length() == 0) {
            tvErrorBirthDate.setText("Birth Date is required");
            tvErrorBirthDate.setVisibility(View.VISIBLE);
        }
        else if (!Util.isDateValid(birthDate)) {
            tvErrorBirthDate.setText("Birth Date needs to be valid.");
            tvErrorBirthDate.setVisibility(View.VISIBLE);
        }
        else {
            tvErrorBirthDate.setVisibility(View.GONE);
        }

        validateSendButton();
    }


    @OnFocusChange({R.id.etNameSurname})
    public void validateNameSurname(View v, boolean hasFocus) {
        if (hasFocus) return;
        String nameSurname = etNameSurname.getText().toString();

        if (nameSurname.length() == 0) {
            tvErrorNameSurname.setText("Name and Surname is required");
            tvErrorNameSurname.setVisibility(View.VISIBLE);
        }
        else if (nameSurname.length() < 2) {
            tvErrorNameSurname.setText("Name and Surname needs to be at least 2 characters.");
            tvErrorNameSurname.setVisibility(View.VISIBLE);
        }
        else {
            tvErrorNameSurname.setVisibility(View.GONE);
        }

        validateSendButton();
    }


    @OnFocusChange({R.id.etCity})
    public void validateCity(View v, boolean hasFocus) {
        if (hasFocus) return;
        String city = etCity.getText().toString();

        if (city.length() == 0) {
            tvErrorCity.setText("City is required");
            tvErrorCity.setVisibility(View.VISIBLE);
        }
        else if (!isCity(city)) {
            tvErrorCity.setText("Please enter a city.");
            tvErrorCity.setVisibility(View.VISIBLE);
        }
        else {
            tvErrorCity.setVisibility(View.GONE);
        }

        validateSendButton();
    }


    private boolean isCity(String city) {
        for (String c: cities) {
            if (c.equals(city))
                return true;
        }
        return false;
    }


    @OnFocusChange({R.id.etText})
    public void validateText(View v, boolean hasFocus) {
        if (hasFocus) return;
        String text = etText.getText().toString();

        if (text.length() == 0) {
            tvErrorText.setText("Text is required");
            tvErrorText.setVisibility(View.VISIBLE);
        }
        else if (text.length() < 10) {
            tvErrorText.setText("Text needs to be at least 10 characters.");
            tvErrorText.setVisibility(View.VISIBLE);
        }
        else {
            tvErrorText.setVisibility(View.GONE);
        }

        validateSendButton();
    }


    public void validateSendButton() {
        String city = etCity.getText().toString();
        String text = etText.getText().toString();
        String birthDate = etBirthDate.getText().toString();
        String nameSurname = etNameSurname.getText().toString();
        boolean isMale = radioButtonMale.isChecked();
        boolean isFemale = radioButtonFemale.isChecked();

        if (isCity(city)) {
            tvErrorCity.setVisibility(View.GONE);
        }

        if (Util.isDateValid(birthDate)) {
            tvErrorBirthDate.setVisibility(View.GONE);
        }

        if (text.length() > 10) {
            tvErrorText.setVisibility(View.GONE);
        }

        if (nameSurname.length() > 2) {
            tvErrorNameSurname.setVisibility(View.GONE);
        }

        if (isFemale || isMale) {
            tvErrorGender.setVisibility(View.GONE);
        }

        if (isCity(city) && Util.isDateValid(birthDate) && text.length() > 10 &&
                nameSurname.length() > 2 && (isFemale || isMale)) {
            btnSend.setEnabled(true);
        }
        else {
            btnSend.setEnabled(false);
        }
    }


    @OnClick({R.id.btnProceed})
    public void directToPoll() {
        String city = etCity.getText().toString().trim();
        String text = etText.getText().toString().trim();
        String birthDate = etBirthDate.getText().toString().trim();
        String nameSurname = etNameSurname.getText().toString().trim();
        boolean isMale = radioButtonMale.isChecked();
        String gender = isMale ? "Male" : "Female";
        Answer answer = new Answer(nameSurname, birthDate, city, gender, text);
        ServiceAnswers.createAnswer(this, answer);
    }


    @OnClick({R.id.btnBack})
    public void back() {
        Objects.requireNonNull(getActivity()).onBackPressed();
    }


    @Override
    public void success(Object data) {
        assert getFragmentManager() != null;
        FragmentManagement.clearBackStack(getFragmentManager());
        FragmentManagement.switchFragment(FragmentManagement.FRAGMENT_ENTER,
                R.id.containerFragment, getFragmentManager(), false);

        Toast.makeText(getContext(), "Thank you for your answer.",
                Toast.LENGTH_LONG).show();
    }


    @Override
    public void error(Object error) {
        Toast.makeText(getContext(), (String) error,
                Toast.LENGTH_LONG).show();

        Toast.makeText(getContext(), "Try Again",
                Toast.LENGTH_LONG).show();
    }
}
