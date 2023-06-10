package com.appdevmhr.bangladeshswedenpolytechnic;

import android.app.ProgressDialog;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String email, password;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setTitle("Please Wait.....");
        dialog.setMessage("We are Trying to Login Your account");
        dialog.setCancelable(false);
        binding.forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, forgetPassword.class);
                startActivity(intent);
            }
        });
        binding.userSigninSigninBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = binding.userSigninEmail.getText().toString();
                password = binding.userSigninPassword.getText().toString();
                if (email.isEmpty()) {
                    binding.userSigninEmail.setError("Email Required");
                    binding.userSigninEmail.requestFocus();
                } else {
                    if (password.isEmpty()) {
                        binding.userSigninPassword.setError("Password Required");
                        binding.userSigninPassword.requestFocus();
                    } else {
                        dialog.show();
                        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                dialog.dismiss();
                                Intent intent = new Intent(getApplicationContext(), Nav.class);
                                startActivity(intent);
                                finish();
                                Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_LONG).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialog.dismiss();
                                Toast.makeText(MainActivity.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();

                            }
                        });

                    }
                }

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser() != null){
            Intent intent = new Intent(getApplicationContext(), Nav.class);
            startActivity(intent);
            finish();
        }

    }
}