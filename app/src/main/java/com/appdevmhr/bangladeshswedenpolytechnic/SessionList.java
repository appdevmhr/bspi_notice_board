package com.appdevmhr.bangladeshswedenpolytechnic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivitySessionListBinding;

public class SessionList extends AppCompatActivity implements simpleMethod{
    ActivitySessionListBinding binding;
    String department, collection, document;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySessionListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        department = getIntent().getStringExtra("department");
        collection = getIntent().getStringExtra("collection");
        document = getIntent().getStringExtra("document");
        setFirestoreRecyclerforSessionUpload(SessionList.this, department+collection, binding.recyclerViewStudentInfo,"SessionList");

    }
}