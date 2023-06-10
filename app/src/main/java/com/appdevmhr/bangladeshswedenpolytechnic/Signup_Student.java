package com.appdevmhr.bangladeshswedenpolytechnic;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivitySignupStudentBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.model.Model_simple_staff_list;
import com.appdevmhr.bangladeshswedenpolytechnic.model.Signup_Student_Model;
import com.appdevmhr.bangladeshswedenpolytechnic.ui.setPeople;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import org.imaginativeworld.oopsnointernet.NoInternetSnackbar;

import java.util.Objects;

public class Signup_Student extends AppCompatActivity implements simpleMethod{

    ActivitySignupStudentBinding binding;
    String collection, document,Session,Shift,Department;
    FirebaseFirestore db;
    Uri selectedImage;
    ProgressDialog dialog;
    String imageUrl;
    NoInternetSnackbar noInternetSnackbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setTitle("Uploading");
        dialog.setCancelable(false);
        dialog.setMessage("Please We are storing Image ...... ");
        collection = getIntent().getStringExtra("collection");
        document = getIntent().getStringExtra("document");
        Session = getIntent().getStringExtra("Session");
        Shift = getIntent().getStringExtra("Shift");
        Department = getIntent().getStringExtra("Department");
        binding.setPhoto.setOnClickListener(view -> ImagePicker.with(Signup_Student.this)
                .crop()                    //Crop image(Optional), Check Customization for more option
                .compress(1028)    //Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                .start());
        binding.submit.setOnClickListener(view -> {
            if (!getStringFromInput(binding.setName, "Name").isEmpty()) {
                if (!getStringFromInput(binding.setRoll, "setRoll").isEmpty()) {
                    if (!getStringFromInput(binding.setRegistration, "registration").isEmpty()) {
                        if (!getStringFromInput(binding.setHomeDistrict, "HomeDistrict").isEmpty()) {
                            if (!getStringFromInput(binding.setStudentMobileNumber, "studentMobileNumber").isEmpty()) {
                                if (!getStringFromInput(binding.setGordianName, "gordianName").isEmpty()) {
                                    if (!getStringFromInput(binding.setGordianMobileNumber, "gordianMobileNumber").isEmpty()) {
                                        if (!getStringFromInput(binding.setEmailAddress, "email").isEmpty()) {
                                            if (!getStringFromInput(binding.setPassword, "password").isEmpty()) {
                                                Signup();

                                                    }

                                                }


                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
        if (!document.isEmpty()) {
            db.collection(collection).document(document).get().addOnSuccessListener(documentSnapshot -> {
                if (documentSnapshot.exists()) {
                    imageUrl = documentSnapshot.getString("photo");
                    setTextFromFireStore(binding.setName, "name", documentSnapshot);
                    setTextFromFireStore(binding.setRoll, "roll", documentSnapshot);
                    setTextFromFireStore(binding.setHomeDistrict, "homeDistrict", documentSnapshot);
                    setTextFromFireStore(binding.setStudentMobileNumber, "studentMobileNumber", documentSnapshot);
                    setTextFromFireStore(binding.setGordianName, "gordianName", documentSnapshot);
                    setTextFromFireStore(binding.setGordianMobileNumber, "gordianMobileNumber", documentSnapshot);
                    setTextFromFireStore(binding.setEmailAddress, "email_address", documentSnapshot);
                    setTextFromFireStore(binding.setPassword, "password", documentSnapshot);
                    Picasso.get().load(documentSnapshot.getString("photo")).placeholder(R.drawable.ic_baseline_account_circle_24).into(binding.setPhoto);


                } else {
                    Toast.makeText(Signup_Student.this, "document not found", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(e -> Toast.makeText(Signup_Student.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show());

        }


    }

    private void Signup() {
        if (selectedImage != null) {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword( getStringFromInput(binding.setEmailAddress, "text"),
                    getStringFromInput(binding.setPassword, "text"))   .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    dialog.show();
                    uploadData();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    dialog.dismiss();
                    Log.d("signup",e.getLocalizedMessage())     ;
                }
            });
        }else {
            if (!imageUrl.isEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword( getStringFromInput(binding.setEmailAddress, "text"),
                        getStringFromInput(binding.setPassword, "text"))   .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        dialog.show();
                        uploadData();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        dialog.dismiss();
                        Log.d("signup",e.getLocalizedMessage())     ;
                    }
                });
            } else {
                Toast.makeText(Signup_Student.this, "No Image Selected", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        }

    }

    private void uploadData() {
        if (selectedImage != null) {
            StorageReference reference = FirebaseStorage.getInstance().getReference().child(collection+document).child(Session+getStringFromInput(binding.setRoll, "text")+getStringFromInput(binding.setRegistration, "text"));
            reference.putFile(selectedImage).addOnSuccessListener(taskSnapshot -> reference.getDownloadUrl().addOnSuccessListener(uri -> {
                imageUrl = uri.toString();
                setData(imageUrl);
            }).addOnFailureListener(e -> {
                dialog.dismiss();
                Toast.makeText(Signup_Student.this, e.getMessage(), Toast.LENGTH_SHORT).show();

            })).addOnFailureListener(e -> {
                dialog.dismiss();
                Toast.makeText(Signup_Student.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            });
        } else {
            if (!imageUrl.isEmpty()) {
                setData(imageUrl);
            } else {
                Toast.makeText(Signup_Student.this, "No Image Selected", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

        }
    }

    private void fillDocument() {

    }

    public void setTextFromFireStore(EditText editText, String fieldName, DocumentSnapshot documentSnapshot) {
        editText.setText(documentSnapshot.getString(fieldName));
    }

    public void setData(String url) {
        Signup_Student_Model model = new Signup_Student_Model(url,getStringFromInput(binding.setName, "text"),
                getStringFromInput(binding.setRoll, "text"),
                getStringFromInput(binding.setRegistration, "text"),
                getStringFromInput(binding.setHomeDistrict, "text"),
                getStringFromInput(binding.setStudentMobileNumber, "text"),
                getStringFromInput(binding.setGordianName, "text"),
                getStringFromInput(binding.setGordianMobileNumber, "text"),
                getStringFromInput(binding.setEmailAddress, "text"),
                getStringFromInput(binding.setPassword, "text"),Session,Shift,Department);

        db.collection(collection).document(document).collection(document).document(Session+getStringFromInput(binding.setRoll, "text")+getStringFromInput(binding.setRegistration, "text")).set(model, SetOptions.merge()).addOnSuccessListener(unused -> {

            db.collection("UserData").document( getStringFromInput(binding.setEmailAddress, "text")).set(model, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    dialog.dismiss();
                    Toast.makeText(Signup_Student.this, "successfully submitted", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    dialog.dismiss();
                    Toast.makeText(Signup_Student.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                }
            });


                }).
                addOnFailureListener(e -> {
                    dialog.dismiss();
                    Toast.makeText(Signup_Student.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            if (data.getData() != null) {
                binding.setPhoto.setImageURI(data.getData());
                selectedImage = data.getData();

            }
        }

    }

}