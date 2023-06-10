package com.appdevmhr.bangladeshswedenpolytechnic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivityBoardResultViewBinding;

public class BoardResultView extends AppCompatActivity implements simpleMethod{
ActivityBoardResultViewBinding binding;
    String collection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBoardResultViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        collection = getIntent().getStringExtra("collection");
        setFirestoreRecyclerforProbidan(this, collection, binding.recyclerViewProbidan);
        binding.addProbidan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetProbidan(BoardResultView.this, uploadProbidan.class,collection,"");
            }
        });
        setAdminWork(binding.addProbidan);
    }
}