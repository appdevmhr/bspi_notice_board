package com.appdevmhr.bangladeshswedenpolytechnic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivityFolderListBinding;

public class FolderList extends AppCompatActivity implements simpleMethod{
ActivityFolderListBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFolderListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }


}