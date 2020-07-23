package com.project458.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.orhanobut.hawk.Hawk;
import com.project458.myapplication.utils.FragmentManagement;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Hawk.init(getApplicationContext()).build();
        FragmentManagement.switchFragment(
                FragmentManagement.FRAGMENT_ENTER,
                R.id.containerFragment,
                getSupportFragmentManager(),
                false);
    }
}