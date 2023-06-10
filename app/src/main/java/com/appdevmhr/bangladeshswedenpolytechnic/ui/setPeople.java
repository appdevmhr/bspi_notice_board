package com.appdevmhr.bangladeshswedenpolytechnic.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.appdevmhr.bangladeshswedenpolytechnic.Nav;
import com.appdevmhr.bangladeshswedenpolytechnic.R;
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivitySetPeopleBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.model.Model_simple_staff_list;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;
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

public class setPeople extends AppCompatActivity implements simpleMethod {
    ActivitySetPeopleBinding binding;
    String collection, document;
    FirebaseFirestore db;
    Uri selectedImage;
    ProgressDialog dialog;
    String imageUrl;
    NoInternetSnackbar noInternetSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySetPeopleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setTitle("Uploading");
        dialog.setCancelable(false);
        dialog.setMessage("Please We are storing Image ...... ");
        collection = getIntent().getStringExtra("collection");
        document = getIntent().getStringExtra("document");
        binding.setPhoto.setOnClickListener(view -> ImagePicker.with(setPeople.this)
                .crop()                    //Crop image(Optional), Check Customization for more option
                .compress(1028)    //Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                .start());
        binding.submit.setOnClickListener(view -> {
            if (!getStringFromInput(binding.setName, "Name").isEmpty()) {
                if (!getStringFromInput(binding.setPost, "Designation").isEmpty()) {
                    if (!getStringFromInput(binding.setSection, "Section").isEmpty()) {
                        if (!getStringFromInput(binding.setHomeDistrict, "HomeDistrict").isEmpty()) {
                            if (!getStringFromInput(binding.setEducation, "Education").isEmpty()) {
                                if (!getStringFromInput(binding.setGovtJobJoiningDate, "GovtJobJoiningDate").isEmpty()) {
                                    if (!getStringFromInput(binding.setCurrentPositionJoinningDate, "CurrentPositionJoinningDate").isEmpty()) {
                                        if (!getStringFromInput(binding.setCurrentInstituteJoinningDate, "CurrentInstituteJoinningDate").isEmpty()) {
                                            if (!getStringFromInput(binding.setMobile, "Mobile Number").isEmpty()) {
                                                if (!getStringFromInput(binding.setEmail, "email").isEmpty()) {
                                                    if (getIntegerFromInput(binding.setPayority, "Sort Number") != 0) {

                                                        SignUp();

                                                    }

                                                }
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
                    imageUrl = documentSnapshot.getString("imagelink");
                    setTextFromFireStore(binding.setName, "simple_staff_list_Name", documentSnapshot);
                    setTextFromFireStore(binding.setPost, "simple_staff_list_post", documentSnapshot);
                    setTextFromFireStore(binding.setHomeDistrict, "homeDistrict", documentSnapshot);
                    setTextFromFireStore(binding.setEducation, "education", documentSnapshot);
                    setTextFromFireStore(binding.setSection, "section", documentSnapshot);
                    setTextFromFireStore(binding.setGovtJobJoiningDate, "govtJobJoiningDate", documentSnapshot);
                    setTextFromFireStore(binding.setCurrentInstituteJoinningDate, "currentInstituteJoinningDate", documentSnapshot);
                    setTextFromFireStore(binding.setCurrentPositionJoinningDate, "currentPositionJoinningDate", documentSnapshot);
                    setTextFromFireStore(binding.setMobile, "mobile", documentSnapshot);
                    setTextFromFireStore(binding.setEmail, "email", documentSnapshot);
                    binding.setPayority.setText(Objects.toString(documentSnapshot.get("piority", Integer.class)));
                    Picasso.get().load(documentSnapshot.getString("imagelink")).placeholder(R.drawable.ic_baseline_account_circle_24).into(binding.setPhoto);


                } else {
                    Toast.makeText(setPeople.this, "document not found", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(e -> Toast.makeText(setPeople.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show());

        }

    }

    private void SignUp() {
        if (selectedImage != null) {
            dialog.show();
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(getStringFromInput(binding.setEmail, "email"), getStringFromInput(binding.setPassword, "password")).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    StorageReference reference = FirebaseStorage.getInstance().getReference().child(collection).child(getStringFromInput(binding.setName, "text"));
                    reference.putFile(selectedImage).addOnSuccessListener(taskSnapshot -> reference.getDownloadUrl().addOnSuccessListener(uri -> {
                        imageUrl = uri.toString();
                        setData(imageUrl);
                    }).addOnFailureListener(e -> {
                        dialog.dismiss();
                        Toast.makeText(setPeople.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    })).addOnFailureListener(e -> {
                        dialog.dismiss();
                        Toast.makeText(setPeople.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
                }
            });
        } else {
            if (!imageUrl.isEmpty()) {
                setData(imageUrl);
            } else {
                Toast.makeText(setPeople.this, "No Image Selected", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

        }
    }

    public void setTextFromFireStore(EditText editText, String fieldName, DocumentSnapshot documentSnapshot) {
        editText.setText(documentSnapshot.getString(fieldName));
    }


    public void setData(String url) {
        Model_simple_staff_list model = new Model_simple_staff_list(getStringFromInput(binding.setName, "text"),
                getStringFromInput(binding.setPost, "text"),
                url,
                getStringFromInput(binding.setSection, "text"),
                getStringFromInput(binding.setHomeDistrict, "text"),
                getStringFromInput(binding.setEducation, "text"),
                getStringFromInput(binding.setGovtJobJoiningDate, "text"),
                getStringFromInput(binding.setCurrentPositionJoinningDate, "text"),
                getStringFromInput(binding.setCurrentInstituteJoinningDate, "text"),
                getStringFromInput(binding.setMobile, "text"),
                getStringFromInput(binding.setEmail, "email"),
                getIntegerFromInput(binding.setPayority, "Sort Number"),
                getStringFromInput(binding.setPassword, "password"), false);


        db.collection(collection).document(getStringFromInput(binding.setName, "text")).set(model, SetOptions.merge()).addOnSuccessListener(unused -> {

                    db.collection("TeacherData").document(
                            getStringFromInput(binding.setEmail, "email")).set(model, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            dialog.dismiss();
                            Toast.makeText(setPeople.this, "successfully submitted", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            dialog.dismiss();
                            Toast.makeText(setPeople.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

                }).
                addOnFailureListener(e -> {
                    dialog.dismiss();
                    Toast.makeText(setPeople.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

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

    @Override
    protected void onResume() {
        super.onResume();
        setNoInternetSnackbar(setPeople.this, noInternetSnackbar);
    }

    @Override
    protected void onPause() {
        super.onPause();
        destroyInternetSnackbar(noInternetSnackbar);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(setPeople.this, Nav.class);
        startActivity(intent);
    }
}