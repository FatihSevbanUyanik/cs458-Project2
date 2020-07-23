package com.project458.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project458.myapplication.R;
import com.project458.myapplication.model.Answer;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterAnswers extends RecyclerView.Adapter<AdapterAnswers.ViewHolder> {

    private ArrayList<Answer> answers;
    private LayoutInflater inflater;

    public AdapterAnswers(Context context, ArrayList<Answer> answers) {
        inflater = LayoutInflater.from(context);
        this.answers = answers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterAnswers.ViewHolder(inflater.inflate(R.layout.list_item_answer, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Answer answer = answers.get(position);
        holder.tvNameSurname.setText(answer.getNameSurname());
        holder.tvBirthDate.setText(answer.getBirthDate());
        holder.tvGender.setText(answer.getGender());
        holder.tvText.setText(answer.getText());
        holder.tvCity.setText(answer.getCity());
    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvNameSurname) TextView tvNameSurname;
        @BindView(R.id.tvBirthDate) TextView tvBirthDate;
        @BindView(R.id.tvGender) TextView tvGender;
        @BindView(R.id.tvCity) TextView tvCity;
        @BindView(R.id.tvText) TextView tvText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
