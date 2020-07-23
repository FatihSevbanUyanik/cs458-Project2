package com.project458.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project458.myapplication.R;
import com.project458.myapplication.adapters.AdapterAnswers;
import com.project458.myapplication.model.Answer;
import com.project458.myapplication.service.InterfaceData;
import com.project458.myapplication.service.ServiceAnswers;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentAnswers extends Fragment implements InterfaceData {

    // UI elements
    @BindView(R.id.rcvAnswers) RecyclerView rcvAnswers;

    // properties
    private ArrayList<Answer> answers;
    private AdapterAnswers adapterAnswers;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootLayout = inflater.inflate(R.layout.fragment_answers, container, false);
        ButterKnife.bind(this, rootLayout);
        return rootLayout;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        answers = new ArrayList<>();
        setupRecyclerView();
        ServiceAnswers.retrieveAnswers(this);
    }


    private void setupRecyclerView() {
        // setting adapter.
        adapterAnswers = new AdapterAnswers(getContext(), answers);
        rcvAnswers.setAdapter(adapterAnswers);

        // setting layout manager.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvAnswers.setLayoutManager(linearLayoutManager);
    }


    @Override
    public void success(Object data) {
        answers.addAll((ArrayList<Answer>) data);
        adapterAnswers.notifyDataSetChanged();
    }


    @Override
    public void error(Object error) {
        Toast.makeText(getContext(), (String) error, Toast.LENGTH_LONG).show();
    }
}
