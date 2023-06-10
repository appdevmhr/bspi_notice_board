package com.appdevmhr.bangladeshswedenpolytechnic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivityStudentListViewBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class StudentListView extends AppCompatActivity implements simpleMethod{
ActivityStudentListViewBinding binding;
    String collection, document,Session,Shift,Department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityStudentListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        collection = getIntent().getStringExtra("collection");
        document = getIntent().getStringExtra("document");
        Session = getIntent().getStringExtra("Session");
        Shift = getIntent().getStringExtra("Shift");
        Department = getIntent().getStringExtra("Department");
        setFirestoreRecyclerforStudentListView(this, collection, binding.recyclerViewStudentList,document,Session,Shift,Department);
        setAdminWork(binding.addStudentList);

        binding.addStudentList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetStudentListView(StudentListView.this, Signup_Student.class,collection,document,Session,Shift,Department);
            }
        });
    }

   
}