package com.appdevmhr.bangladeshswedenpolytechnic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivityFullViewImageBinding;
import com.squareup.picasso.Picasso;

public class FullViewImage extends AppCompatActivity {
ActivityFullViewImageBinding binding;
String photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFullViewImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        photo = getIntent().getStringExtra("photo");
        Picasso.get().load(photo).placeholder(R.drawable.ic_baseline_account_circle_24).into(binding.imageView5);

    }
}