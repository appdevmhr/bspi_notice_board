package com.appdevmhr.bangladeshswedenpolytechnic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivityStudentDetailsBinding;
import com.squareup.picasso.Picasso;

public class StudentDetails extends AppCompatActivity {
ActivityStudentDetailsBinding binding;
    String photo,name,roll,registration,homeDistrict,studentMobileNumber,gordianName,gordianMobileNumber,email_address,session,shift,department;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        name = getIntent().getStringExtra("name");
        roll = getIntent().getStringExtra("roll");
        registration = getIntent().getStringExtra("registration");
        homeDistrict = getIntent().getStringExtra("homeDistrict");
        studentMobileNumber = getIntent().getStringExtra("studentMobileNumber");
        gordianName = getIntent().getStringExtra("gordianName");
        gordianMobileNumber = getIntent().getStringExtra("gordianMobileNumber");
        email_address = getIntent().getStringExtra("email_address");
        session = getIntent().getStringExtra("session");
        shift = getIntent().getStringExtra("shift");
        department = getIntent().getStringExtra("department");
        photo = getIntent().getStringExtra("photo");

        binding.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentDetails.this, FullViewImage.class);
                intent.putExtra("photo",photo);
                startActivity(intent);
            }
        });
        binding.name.setText(name);
        binding.roll.setText("Roll :"+roll);
        binding.Registration.setText(registration);
        binding.HomeDistrict.setText(homeDistrict);
        binding.StudentMobileNumber.setText("+88"+studentMobileNumber);
        binding.GordianName.setText(gordianName);
        binding.GordianMobileNumber.setText("+88"+gordianMobileNumber);
        binding.EmailAddress.setText(email_address);
        binding.Session.setText(session);
        binding.Shift.setText(shift);
        binding.Department.setText(department);
        Picasso.get().load(photo).placeholder(R.drawable.ic_baseline_account_circle_24).into(binding.photo);


    }
}