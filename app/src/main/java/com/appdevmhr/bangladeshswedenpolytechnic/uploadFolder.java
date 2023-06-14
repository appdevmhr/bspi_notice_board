package com.appdevmhr.bangladeshswedenpolytechnic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivityUploadFolderBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.model.uploadFolderListModel;
import com.appdevmhr.bangladeshswedenpolytechnic.model.uploadSessionModel;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import org.imaginativeworld.oopsnointernet.NoInternetSnackbar;

public class uploadFolder extends AppCompatActivity implements simpleMethod{
    ActivityUploadFolderBinding binding;
    String collection;
    FirebaseFirestore db;
    Uri selectedImage;
    ProgressDialog dialog;
    String imageUrl;
    NoInternetSnackbar noInternetSnackbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUploadFolderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setTitle("Uploading");
        dialog.setCancelable(false);
        dialog.setMessage("Please We are storing Image ...... ");
        collection = getIntent().getStringExtra("collection");
        binding.sessionSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!getStringFromInput(binding.foldername, "Name").isEmpty()) {
                    if (!getStringFromInput(binding.folderDate, "Name").isEmpty()) {
                        setData();
                    }
                }
            }
        });

    }
    public void setData() {
        uploadFolderListModel model = new uploadFolderListModel(getStringFromInput(binding.foldername, "text"),
                getStringFromInput(binding.folderDate, "text"));

        db.collection(collection).document( getStringFromInput(binding.foldername, "text").toString() + getStringFromInput(binding.folderDate, "text").toString()).set(model, SetOptions.merge()).addOnSuccessListener(unused -> {
                    dialog.dismiss();
                    Toast.makeText(uploadFolder.this, "successfully submitted", Toast.LENGTH_SHORT).show();
                    finish();
                }).
                addOnFailureListener(e -> {
                    dialog.dismiss();
                    Toast.makeText(uploadFolder.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                });

    }
}