package com.appdevmhr.bangladeshswedenpolytechnic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivityForgetPasswordBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class forgetPassword extends AppCompatActivity {
ActivityForgetPasswordBinding binding;
    String email;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialog = new ProgressDialog(forgetPassword.this);
        dialog.setTitle("Please Wait.....");
        dialog.setMessage("We are Trying to Send Reset Password Mail");
        dialog.setCancelable(false);
        binding.userSigninSigninBottom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = binding.editTextTextEmailAddress.getText().toString();
                if (email.isEmpty()){
                    binding.editTextTextEmailAddress.setError("Email Required");
                    binding.editTextTextEmailAddress.requestFocus();
                }else {
                    dialog.show();
                    FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            dialog.dismiss();
                            Toast.makeText(forgetPassword.this, "Successfully send Mail. Please Check your Mail Inbox and spam", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            dialog.dismiss();
                            Toast.makeText(forgetPassword.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();

                        }
                    });

                }

            }
        });

    }
}