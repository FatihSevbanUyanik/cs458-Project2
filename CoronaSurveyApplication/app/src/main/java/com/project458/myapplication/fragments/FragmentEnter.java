package com.project458.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.orhanobut.hawk.Hawk;
import com.project458.myapplication.R;
import com.project458.myapplication.utils.Constants;
import com.project458.myapplication.utils.FragmentManagement;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentEnter extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootLayout = inflater.inflate(R.layout.fragment_enter, container, false);
        ButterKnife.bind(this, rootLayout);
        return rootLayout;
    }

    @OnClick({R.id.btnAttendPoll})
    public void directToCredentials() {
        FragmentManagement.switchFragment(FragmentManagement.FRAGMENT_CREDENTIALS, R.id.containerFragment,
                getFragmentManager(), true);
    }


}
