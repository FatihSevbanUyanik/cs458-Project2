package com.project458.myapplication.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.orhanobut.hawk.Hawk;
import com.project458.myapplication.R;
import com.project458.myapplication.utils.Constants;
import com.project458.myapplication.utils.FragmentManagement;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentCredentials extends Fragment {

    // UI elements
    @BindView(R.id.tvErrorNameSurname) TextView tvErrorNameSurname;
    @BindView(R.id.tvErrorBirthDate) TextView tvErrorBirthDate;
    @BindView(R.id.tvErrorGender) TextView tvErrorGender;
    @BindView(R.id.tvErrorCity) TextView tvErrorCity;
    @BindView(R.id.etNameSurname) EditText etNameSurname;
    @BindView(R.id.etBirthDate) EditText etBirthDate;
    @BindView(R.id.etCity) EditText etCity;
    @BindView(R.id.radioButtonMale) RadioButton radioButtonMale;
    @BindView(R.id.radioButtonFemale) RadioButton radioButtonFemale;
    @BindView(R.id.radioGroupGender) RadioGroup radioGroupGender;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootLayout = inflater.inflate(R.layout.fragment_credentials, container, false);
        ButterKnife.bind(this, rootLayout);
        return rootLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextWatcher textWatcher = createTextWatcher();
        etNameSurname.addTextChangedListener(textWatcher);
        etBirthDate.addTextChangedListener(textWatcher);
        etCity.addTextChangedListener(textWatcher);
    }

    private TextWatcher createTextWatcher() {
        return new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (etNameSurname.getText().toString().length() > 0) {
                    tvErrorNameSurname.setVisibility(View.GONE);
                }
                if (etBirthDate.getText().toString().length() > 0) {
                    tvErrorBirthDate.setVisibility(View.GONE);
                }
                if (etCity.getText().toString().length() > 0) {
                    tvErrorCity.setVisibility(View.GONE);
                }
                if (radioButtonFemale.isChecked() || radioButtonMale.isChecked()) {
                    tvErrorGender.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        };
    }

    @OnClick({R.id.btnProceed})
    public void directToPoll() {
        String city = etCity.getText().toString().trim();
        String birthDate = etBirthDate.getText().toString().trim();
        String nameSurname = etNameSurname.getText().toString().trim();
        tvErrorNameSurname.setVisibility(View.GONE);
        tvErrorBirthDate.setVisibility(View.GONE);
        tvErrorCity.setVisibility(View.GONE);
        boolean hasValidationError = false;

        if (nameSurname.length() <= 2) {
            tvErrorNameSurname.setText("Name surname must contain at least two characters.");
            tvErrorNameSurname.setVisibility(View.VISIBLE);
            hasValidationError = true;
        }

        if (birthDate.length() == 0) {
            tvErrorBirthDate.setText("Birth Date is required");
            tvErrorBirthDate.setVisibility(View.VISIBLE);
            hasValidationError = true;
        }

        if (city.length() == 0) {
            tvErrorCity.setText("City is required");
            tvErrorCity.setVisibility(View.VISIBLE);
            hasValidationError = true;
        }

        if (!radioButtonFemale.isChecked() && !radioButtonMale.isChecked()) {
            tvErrorGender.setText("Gender is required");
            tvErrorGender.setVisibility(View.VISIBLE);
        }

        if (hasValidationError) return;

        Hawk.put(Constants.CRED_NAME_SURNAME, nameSurname);
        Hawk.put(Constants.CRED_BIRTH_DATE, birthDate);
        Hawk.put(Constants.CRED_CITY, city);

        if (radioButtonMale.isChecked()) {
            Hawk.put(Constants.CRED_GENDER, "Male");
        } else if (radioButtonFemale.isChecked()) {
            Hawk.put(Constants.CRED_GENDER, "Female");
        }

        FragmentManagement.switchFragment(FragmentManagement.FRAGMENT_POLL, R.id.containerFragment,
                getFragmentManager(), true);
    }

}
