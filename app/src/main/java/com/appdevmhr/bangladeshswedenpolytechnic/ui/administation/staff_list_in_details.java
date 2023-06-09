package com.appdevmhr.bangladeshswedenpolytechnic.ui.administation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.appdevmhr.bangladeshswedenpolytechnic.Nav;
import com.appdevmhr.bangladeshswedenpolytechnic.R;
import com.squareup.picasso.Picasso;

public class staff_list_in_details extends AppCompatActivity {
    com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivityStaffListInDetailsBinding binding;
    String name, post, Photolink,section, homeDistrict, education, govtJobJoiningDate, currentPositionJoinningDate, currentInstituteJoinningDate, mobile, email;
    int Photo;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivityStaffListInDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        name = getIntent().getStringExtra("name");
        post = getIntent().getStringExtra("post");
        Photo = getIntent().getIntExtra("photo", R.drawable.abdul_motaleb);
        Photolink = getIntent().getStringExtra("photoLink");
        section = getIntent().getStringExtra("section");
        homeDistrict = getIntent().getStringExtra("homeDistrict");
        education = getIntent().getStringExtra("education");
        govtJobJoiningDate = getIntent().getStringExtra("govtJobJoiningDate");
        currentPositionJoinningDate = getIntent().getStringExtra("currentPositionJoinningDate");
        currentInstituteJoinningDate = getIntent().getStringExtra("currentInstituteJoinningDate");
        mobile = getIntent().getStringExtra("mobile");
        email = getIntent().getStringExtra("email");
        binding.name.setText(name);
        binding.Designation.setText("Designation : " + post);
        binding.Section.setText(section);
        binding.HomeDistrict.setText(homeDistrict);
        binding.Education.setText(education);
        binding.GovtJobJoiningDate.setText(govtJobJoiningDate);
        binding.CurrentPositionJoinningDate.setText(currentPositionJoinningDate);
        binding.CurrentInstituteJoinningDate.setText(currentInstituteJoinningDate);
        binding.Mobile.setText("+88" + mobile);
        binding.Email.setText(email);
        Picasso.get().load(Photolink).placeholder(R.drawable.ic_baseline_account_circle_24).into(binding.imageView6);
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
