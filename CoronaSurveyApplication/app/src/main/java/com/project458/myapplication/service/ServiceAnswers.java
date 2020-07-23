package com.project458.myapplication.service;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.project458.myapplication.model.Answer;

import java.util.ArrayList;

public class ServiceAnswers {

    public static void createAnswer(InterfaceData interfaceData, Answer answer) {
        FirebaseFirestore.getInstance().collection("answers")
                .add(answer)
                .addOnSuccessListener(documentReference -> {
                    interfaceData.success("created");
                })
                .addOnFailureListener(e -> {
                    interfaceData.error(e.getLocalizedMessage());
                });
    }


    public static void retrieveAnswers(InterfaceData interfaceData) {
        FirebaseFirestore.getInstance().collection("answers")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        ArrayList<Answer> answers = new ArrayList<>();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Answer answer = new Answer(document.getData());
                            answers.add(answer);
                        }

                        interfaceData.success(answers);
                    }
                    else {
                        interfaceData.error(task.getException().getLocalizedMessage());
                    }
                });
    }

}
