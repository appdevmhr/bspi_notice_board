package com.appdevmhr.bangladeshswedenpolytechnic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivityUploadProbidanBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.model.Model_simple_staff_list;
import com.appdevmhr.bangladeshswedenpolytechnic.model.ProbidanModel;
import com.appdevmhr.bangladeshswedenpolytechnic.ui.setPeople;
import com.codekidlabs.storagechooser.StorageChooser;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.imaginativeworld.oopsnointernet.NoInternetSnackbar;

import ir.smartdevelopers.smartfilebrowser.customClasses.SFBFileFilter;
import ir.smartdevelopers.smartfilebrowser.customClasses.SmartFilePicker;

public class uploadProbidan extends AppCompatActivity implements simpleMethod {
    ActivityUploadProbidanBinding binding;
    String collection, document;
    FirebaseFirestore db;
    Uri selectedImage;
    ProgressDialog dialog;
    String imageUrl;
    NoInternetSnackbar noInternetSnackbar;
    private int EXTERNAL_STORAGE_PERMISSION_CODE = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUploadProbidanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setTitle("Uploading");
        dialog.setCancelable(false);
        dialog.setMessage("Please We are storing Image ...... ");
        collection = getIntent().getStringExtra("collection");
        document = getIntent().getStringExtra("document");

        StorageChooser chooser = new StorageChooser.Builder()
                .withActivity(uploadProbidan.this)
                .withFragmentManager(getFragmentManager())
                .withMemoryBar(true)
                .build();

// Show dialog whenever you want by

        binding.ProbidanSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!getStringFromInput(binding.ProbidanName, "Name").isEmpty()) {
                    if (!getStringFromInput(binding.ProbidanTitle, "Name").isEmpty()) {
                        if (!getStringFromInput(binding.ProbidanDes, "Name").isEmpty()) {
                            ActivityCompat.requestPermissions(uploadProbidan.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                    EXTERNAL_STORAGE_PERMISSION_CODE);
                            dialog.show();
                          OpenFilePicker();

                        }
                    }
                }

            }
        });

    }

    public void setTextFromFireStore(EditText editText, String fieldName, DocumentSnapshot documentSnapshot) {
        editText.setText(documentSnapshot.getString(fieldName));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==10){
            if (data!=null) {
                Uri[] uris= SmartFilePicker.getResultUris(data);
                if (uris!=null){
                   for (Uri uri : uris){
                       upload(uri);
                   }
                }
                Bundle extra= SmartFilePicker.getExtra(data);
                if (extra != null) {
                    int number = extra.getInt("my_number");
                }
            }
        }
    }
    public void OpenFilePicker(){
        Bundle extra=new Bundle();
        extra.putInt("my_number",10);
        Intent intent = new SmartFilePicker.IntentBuilder()
                .showCamera(true)
                .canSelectMultipleInGallery(true)
                .showGalleryTab(true)
                .showPickFromSystemGalleyMenu(true)
                .setExtra(extra)
                .setFileFilter(new SFBFileFilter.Builder().isFile(true).isFolder(true).build())
                .canSelectMultipleInFiles(true)
                .build(this);
        startActivityForResult(intent, 10);
    }

    public void upload(Uri path){
        StorageReference reference = FirebaseStorage.getInstance().getReference().child(collection).child(getStringFromInput(binding.ProbidanName, "text").toString()+getStringFromInput(binding.ProbidanName, "text").toString());
        reference.putFile(path).addOnSuccessListener(taskSnapshot -> reference.getDownloadUrl().addOnSuccessListener(uri -> {
            imageUrl = uri.toString();
            setData(imageUrl);
        }).addOnFailureListener(e -> {
            dialog.dismiss();
            Toast.makeText(uploadProbidan.this, e.getMessage(), Toast.LENGTH_SHORT).show();

        })).addOnFailureListener(e -> {
            dialog.dismiss();
            Toast.makeText(uploadProbidan.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        });
    }
    public void setData(String url) {
        ProbidanModel model = new ProbidanModel(getStringFromInput(binding.ProbidanName, "text"),
                getStringFromInput(binding.ProbidanTitle, "text"),
                getStringFromInput(binding.ProbidanDes, "text"),url);

        db.collection(collection).document(getStringFromInput(binding.ProbidanName, "text").toString() + getStringFromInput(binding.ProbidanTitle, "text").toString()).set(model, SetOptions.merge()).addOnSuccessListener(unused -> {
                    dialog.dismiss();
                    Toast.makeText(uploadProbidan.this, "successfully submitted", Toast.LENGTH_SHORT).show();
                    finish();
                }).
                addOnFailureListener(e -> {
                    dialog.dismiss();
                    Toast.makeText(uploadProbidan.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                });

    }

    @Override
    protected void onResume() {
        super.onResume();
        setNoInternetSnackbar(uploadProbidan.this, noInternetSnackbar);
    }

    @Override
    protected void onPause() {
        super.onPause();
        destroyInternetSnackbar(noInternetSnackbar);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(uploadProbidan.this, Nav.class);
        startActivity(intent);
    }
}