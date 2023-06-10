package com.appdevmhr.bangladeshswedenpolytechnic;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appdevmhr.bangladeshswedenpolytechnic.adapter.adapter_simple_staff_list_Image;
import com.appdevmhr.bangladeshswedenpolytechnic.adapter.probidanAdapter;
import com.appdevmhr.bangladeshswedenpolytechnic.adapter.sessionUploadAdapter;
import com.appdevmhr.bangladeshswedenpolytechnic.model.Model_simple_staff_list;
import com.appdevmhr.bangladeshswedenpolytechnic.model.ProbidanModel;
import com.appdevmhr.bangladeshswedenpolytechnic.model.Signup_Student_Model;
import com.appdevmhr.bangladeshswedenpolytechnic.model.uploadSessionModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import org.imaginativeworld.oopsnointernet.NoInternetSnackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface simpleMethod {
    default void setIntent(Context thisActivity, Class sendActivity) {
        Intent intent = new Intent(thisActivity, sendActivity);
        thisActivity.startActivity(intent);
    }
    boolean ADMIN_ACCOUNT = false;
   default   void setAdminWork(FloatingActionButton addStudentList) {
//        FirebaseAuth auth;
//        FirebaseFirestore database;
//        database = FirebaseFirestore.getInstance();
//        auth = FirebaseAuth.getInstance();
        if (ADMIN_ACCOUNT == true){
            addStudentList.setVisibility(View.VISIBLE);
        }
//        database.collection("TeacherData").document(auth.getCurrentUser().getEmail()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//
//                if (documentSnapshot.get("admin").toString().equals("true")){
//                    addStudentList.setVisibility(View.VISIBLE);
//                }else {
//                    addStudentList.setVisibility(View.GONE);
//                }
//
//            }
//        });

    }

    default void setIntentForSetPeaple(Context thisActivity, Class sendActivity,String collection,String document) {
        Intent intent = new Intent(thisActivity, sendActivity);
        intent.putExtra("collection",collection);
        intent.putExtra("document",document);
        thisActivity.startActivity(intent);
//        ((Activity)thisActivity).finish();
    }
    default void setIntentForSetProbidan(Context thisActivity, Class sendActivity,String collection,String document) {
        Intent intent = new Intent(thisActivity, sendActivity);
        intent.putExtra("collection",collection);
        intent.putExtra("document",document);
        thisActivity.startActivity(intent);
//        ((Activity)thisActivity).finish();
    }
    default void setIntentForSetStudentListView(Context thisActivity, Class sendActivity,String collection,String document,String Session,String Shift,String Department) {
        Intent intent = new Intent(thisActivity, sendActivity);
        intent.putExtra("collection",collection);
        intent.putExtra("document",document);
        intent.putExtra("Session",Session);
        intent.putExtra("Shift",Shift);
        intent.putExtra("Department",Department);
        thisActivity.startActivity(intent);
//        ((Activity)thisActivity).finish();
    }
    default void setIntentForSetUploadSession(Context thisActivity, Class sendActivity,String collection,String document,String depertment) {
        Intent intent = new Intent(thisActivity, sendActivity);
        intent.putExtra("collection",collection);
        intent.putExtra("document",document);
        intent.putExtra("department",depertment);
        thisActivity.startActivity(intent);
//        ((Activity)thisActivity).finish();
    }
    default void setFirestoreRecycler(Context context, String collection, RecyclerView recyclerView) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setTitle("Loading");
        dialog.setMessage("Please Wait ......");
        dialog.show();
        dialog.setCancelable(false);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .setCacheSizeBytes(FirebaseFirestoreSettings.CACHE_SIZE_UNLIMITED)
                .build();
        db.setFirestoreSettings(settings);
        ArrayList<Model_simple_staff_list> list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        adapter_simple_staff_list_Image adapter = new adapter_simple_staff_list_Image(context,collection, list);
        db.collection(collection).orderBy("piority", Query.Direction.ASCENDING).
                get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        dialog.dismiss();
                        List<DocumentSnapshot> dataList = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : dataList) {
                            Model_simple_staff_list obj = d.toObject(Model_simple_staff_list.class);
                            list.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        dialog.dismiss();
                        Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
    default void setFirestoreRecyclerforStudentListView(Context context, String collection, RecyclerView recyclerView, String document, String session, String shift, String department) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setTitle("Loading");
        dialog.setMessage("Please Wait ......");
        dialog.show();
        dialog.setCancelable(false);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .setCacheSizeBytes(FirebaseFirestoreSettings.CACHE_SIZE_UNLIMITED)
                .build();
        db.setFirestoreSettings(settings);
        ArrayList<Signup_Student_Model> list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        StudentListAdapter adapter = new StudentListAdapter(context,collection, document,session,shift,department,list);
        db.collection(collection).document(document).collection(document).orderBy("roll", Query.Direction.ASCENDING).
                get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        dialog.dismiss();
                        List<DocumentSnapshot> dataList = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : dataList) {
                            Signup_Student_Model obj = d.toObject(Signup_Student_Model.class);
                            list.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        dialog.dismiss();
                        Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
    default void setFirestoreRecyclerforProbidan(Context context, String collection, RecyclerView recyclerView) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setTitle("Loading");
        dialog.setMessage("Please Wait ......");
        dialog.show();
        dialog.setCancelable(false);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .setCacheSizeBytes(FirebaseFirestoreSettings.CACHE_SIZE_UNLIMITED)
                .build();
        db.setFirestoreSettings(settings);
        ArrayList<ProbidanModel> list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        probidanAdapter adapter = new probidanAdapter(context,collection, list);
        db.collection(collection).
                get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        dialog.dismiss();
                        List<DocumentSnapshot> dataList = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : dataList) {
                            ProbidanModel obj = d.toObject(ProbidanModel.class);
                            list.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        dialog.dismiss();
                        Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
 default void setFirestoreRecyclerforSessionUpload(Context context, String collection, RecyclerView recyclerView) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setTitle("Loading");
        dialog.setMessage("Please Wait ......");
        dialog.show();
        dialog.setCancelable(false);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .setCacheSizeBytes(FirebaseFirestoreSettings.CACHE_SIZE_UNLIMITED)
                .build();
        db.setFirestoreSettings(settings);
        ArrayList<uploadSessionModel> list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        sessionUploadAdapter adapter = new sessionUploadAdapter(context,collection, list);
        db.collection(collection).
                get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        dialog.dismiss();
                        List<DocumentSnapshot> dataList = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : dataList) {
                            uploadSessionModel obj = d.toObject(uploadSessionModel.class);
                            list.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        dialog.dismiss();
                        Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }


    default String getStringFromInput(EditText input, String Type) {

        String temString = input.getText().toString();
        Pattern email_pattern, password_pattern;
        Matcher password_matcher, email_matcher;
        String EMAIL_PATTERN = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        email_pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        email_matcher = email_pattern.matcher(temString);


        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        password_pattern = Pattern.compile(PASSWORD_PATTERN);
        password_matcher = password_pattern.matcher(temString);

        if (temString.isEmpty()) {
            input.setError("Required " + Type + " !!!");
            input.requestFocus();
        } else {
            if (Type.equals("Email")) {
                if (!email_matcher.matches()) {
                    input.setError("Required Valid " + Type + " Address !!!");
                    input.requestFocus();
                }

            } else if (Type.equals("Password")) {
                if (!password_matcher.matches()) {
                    input.setError("Required Valid " + Type + " !!!");
                    input.requestFocus();
                }

            }

        }
        return temString;
    }
    default int getIntegerFromInput(EditText input, String Type) {

        String temString = input.getText().toString();
        int number=999;
        if (temString.isEmpty()) {
            input.setError("Required " + Type + " !!!");
            input.requestFocus();
        } else {
           number = Integer.parseInt(temString);


        }
        return number;
    }

    default void setNoInternetSnackbar(Activity activity, NoInternetSnackbar noInternetSnackbar) {

        NoInternetSnackbar.Builder builder2 = new NoInternetSnackbar.Builder(activity, activity.findViewById(android.R.id.content));

        // Optional
        builder2.setConnectionCallback(hasActiveConnection -> {
            // ...
        });
        builder2.setIndefinite(true); // Optional
        builder2.setNoInternetConnectionMessage("No active Internet connection!"); // Optional
        builder2.setOnAirplaneModeMessage("You have turned on the airplane mode!"); // Optional
        builder2.setSnackbarActionText("Settings");
        builder2.setShowActionToDismiss(false);
        builder2.setSnackbarDismissActionText("OK");

        noInternetSnackbar = builder2.build();
    }

    default void destroyInternetSnackbar(NoInternetSnackbar noInternetSnackbar) {

        if (noInternetSnackbar != null) {
            noInternetSnackbar.destroy();
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    default void setWebview(WebView webview, String url) {
        webview.loadUrl(url);
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setLoadsImagesAutomatically(true);
        webview.getSettings().setJavaScriptEnabled(true);
    }
}
