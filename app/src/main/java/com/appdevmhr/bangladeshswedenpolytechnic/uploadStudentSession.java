package com.appdevmhr.bangladeshswedenpolytechnic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivityUploadStudentSessionBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.model.ProbidanModel;
import com.appdevmhr.bangladeshswedenpolytechnic.model.uploadSessionModel;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import org.imaginativeworld.oopsnointernet.NoInternetSnackbar;

public class uploadStudentSession extends AppCompatActivity implements simpleMethod {
    ActivityUploadStudentSessionBinding binding;
    String collection, document, department;
    FirebaseFirestore db;
    Uri selectedImage;
    ProgressDialog dialog;
    String imageUrl;
    NoInternetSnackbar noInternetSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUploadStudentSessionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setTitle("Uploading");
        dialog.setCancelable(false);
        dialog.setMessage("Please We are storing Image ...... ");
        collection = getIntent().getStringExtra("collection");
        document = getIntent().getStringExtra("document");
        department = getIntent().getStringExtra("department");

        binding.sessionSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!getStringFromInput(binding.session, "Name").isEmpty()) {
                    if (!getStringFromInput(binding.shift, "Name").isEmpty()) {
                        setData();
                    }
                }
            }
        });
    }

    public void setData() {
        uploadSessionModel model = new uploadSessionModel(getStringFromInput(binding.session, "text"),
                getStringFromInput(binding.shift, "text"),department);

        db.collection(collection).document(department.toString() + getStringFromInput(binding.session, "text").toString() + getStringFromInput(binding.shift, "text").toString()).set(model, SetOptions.merge()).addOnSuccessListener(unused -> {
                    dialog.dismiss();
                    Toast.makeText(uploadStudentSession.this, "successfully submitted", Toast.LENGTH_SHORT).show();
                    finish();
                }).
                addOnFailureListener(e -> {
                    dialog.dismiss();
                    Toast.makeText(uploadStudentSession.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                });

    }

}