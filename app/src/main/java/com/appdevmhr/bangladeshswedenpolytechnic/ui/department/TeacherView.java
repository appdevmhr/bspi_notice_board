package com.appdevmhr.bangladeshswedenpolytechnic.ui.department;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivityTeacherViewBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;
import com.appdevmhr.bangladeshswedenpolytechnic.ui.setPeople;

public class TeacherView extends AppCompatActivity implements simpleMethod {
    ActivityTeacherViewBinding binding;
    String collection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTeacherViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        collection = getIntent().getStringExtra("collection");
        setFirestoreRecycler(TeacherView.this, collection, binding.recyclerView2);
        binding.floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(TeacherView.this, setPeople.class,collection,"");
            }
        });

    }
}