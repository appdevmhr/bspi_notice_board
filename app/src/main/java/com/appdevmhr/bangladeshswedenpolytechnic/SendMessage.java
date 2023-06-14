package com.appdevmhr.bangladeshswedenpolytechnic;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.appdevmhr.bangladeshswedenpolytechnic.adapter.SendMessageAdapter;
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivitySendMessageBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.model.Model_simple_staff_list;
import com.appdevmhr.bangladeshswedenpolytechnic.model.SendMessageModel;
import com.appdevmhr.bangladeshswedenpolytechnic.ui.setPeople;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Date;


public class SendMessage extends AppCompatActivity implements simpleMethod {
    String collection, document, Session, Shift, Department;
    FirebaseDatabase db;
    FirebaseFirestore fdb;
    FirebaseAuth auth;
    Uri selectedImage;
    ProgressDialog dialog;
    String imageUrl;
    ActivitySendMessageBinding binding;
    String rendomkey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = FirebaseDatabase.getInstance();
        fdb =FirebaseFirestore.getInstance();
        rendomkey = db.getReference().push().getKey();
        collection = getIntent().getStringExtra("collection");
        document = getIntent().getStringExtra("document");
        Session = getIntent().getStringExtra("Session");
        Shift = getIntent().getStringExtra("Shift");
        Department = getIntent().getStringExtra("Department");
        dialog = new ProgressDialog(this);
        dialog.setTitle("Uploading");
        dialog.setCancelable(false);
        dialog.setMessage("Please We are storing Image ...... ");
        binding.chatdeeatlsCamera.setOnClickListener(view -> ImagePicker.with(SendMessage.this)
                .crop()                    //Crop image(Optional), Check Customization for more option
                .compress(1028)    //Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                .start());

        binding.chatdeeatlsSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!getStringFromInput(binding.chatdeeatlsEditText, "Name").isEmpty()) {
                    setData();
                }
            }
        });
        setFirestoreRecyclerforSendMess(SendMessage.this,Department, Session,Shift,binding.recyclerView);
    }

    public void setData() {
        SendMessageModel model = new SendMessageModel("NoPhotoAvailable",getStringFromInput(binding.chatdeeatlsEditText, "text"), Department, Session, Shift);
        model.setTimestamp(new Date().getTime());
        binding.chatdeeatlsEditText.setText("");

        fdb.collection("Send_Message").document(Department).collection(Session+Shift).document(rendomkey).set(model).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                dialog.dismiss();
                Toast.makeText(SendMessage.this, "successfully submitted", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.dismiss();
                Toast.makeText(SendMessage.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
//        db.getReference().child(Department).child(Session).child(Shift).child(rendomkey).setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void unused) {
//                dialog.dismiss();
//                Toast.makeText(SendMessage.this, "successfully submitted", Toast.LENGTH_SHORT).show();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                dialog.dismiss();
//                Toast.makeText(SendMessage.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            if (data.getData() != null) {
                selectedImage = data.getData();
                if (selectedImage != null) {
                    dialog.show();
                    StorageReference reference = FirebaseStorage.getInstance().getReference().child("SendMessage").child(Department + Session + Shift).child(rendomkey);
                    reference.putFile(selectedImage).addOnSuccessListener(taskSnapshot -> reference.getDownloadUrl().addOnSuccessListener(uri -> {
                        imageUrl = uri.toString();
                        SendMessageModel model = new SendMessageModel(imageUrl, "photo_bspi_cst", Department, Session, Shift);
                        model.setTimestamp(new Date().getTime());
                        fdb.collection("Send_Message").document(Department).collection(Session+Shift).document(rendomkey).set(model).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialog.dismiss();
                                Toast.makeText(SendMessage.this, "successfully Send Message", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialog.dismiss();
                                Toast.makeText(SendMessage.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                            }
                        });
                    }).addOnFailureListener(e -> {
                        dialog.dismiss();
                        Toast.makeText(SendMessage.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    })).addOnFailureListener(e -> {
                        dialog.dismiss();
                        Toast.makeText(SendMessage.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
                }
            }
        }
    }

}


