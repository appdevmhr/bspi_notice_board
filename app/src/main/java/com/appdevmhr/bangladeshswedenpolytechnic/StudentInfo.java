package com.appdevmhr.bangladeshswedenpolytechnic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivityStudentInfoBinding;

public class StudentInfo extends AppCompatActivity implements simpleMethod{
ActivityStudentInfoBinding binding;
String department,collection,document;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        department = getIntent().getStringExtra("department");
        collection = getIntent().getStringExtra("collection");
        document = getIntent().getStringExtra("document");
        binding.addStudentInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetUploadSession(StudentInfo.this, uploadStudentSession.class,department+collection,document,department);
            }
        });
        setFirestoreRecyclerforSessionUpload(StudentInfo.this, department+collection, binding.recyclerViewStudentInfo);
    }
}