package com.project458.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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

public class FragmentPoll extends Fragment {

    @BindView(R.id.editTextTextMultiLine) EditText etAnswer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootLayout = inflater.inflate(R.layout.fragment_poll, container, false);
        ButterKnife.bind(this, rootLayout);
        return rootLayout;
    }

    @OnClick({R.id.btnSend})
    public void directToEnter() {

        String nameSurname = Hawk.get(Constants.CRED_NAME_SURNAME);
        String birthDate = Hawk.get(Constants.CRED_BIRTH_DATE);
        String gender = Hawk.get(Constants.CRED_GENDER);
        String city = Hawk.get(Constants.CRED_CITY);

        System.out.println("======================================================");
        System.out.println("Name-Surname:" + nameSurname);
        System.out.println("Birth-Date  :" + birthDate);
        System.out.println("Gender      :" + gender);
        System.out.println("City        :" + city);
        System.out.println("Answer      :" + etAnswer.getText().toString());
        System.out.println("======================================================");

        FragmentManagement.switchFragment(FragmentManagement.FRAGMENT_ENTER, R.id.containerFragment,
                getFragmentManager(), true);
    }

}
