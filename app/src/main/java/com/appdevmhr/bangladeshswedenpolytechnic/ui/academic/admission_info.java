package com.appdevmhr.bangladeshswedenpolytechnic.ui.academic;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;

import com.appdevmhr.bangladeshswedenpolytechnic.R;
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentAdmissionInfoBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;
import com.appdevmhr.bangladeshswedenpolytechnic.uploadProbidan;

import org.imaginativeworld.oopsnointernet.ConnectionCallback;
import org.imaginativeworld.oopsnointernet.NoInternetSnackbar;

public class admission_info extends Fragment implements simpleMethod {

    public admission_info() {
        // Required empty public constructor
    }

 FragmentAdmissionInfoBinding binding;
    NoInternetSnackbar noInternetSnackbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAdmissionInfoBinding.inflate(inflater, container, false);
        setFirestoreRecyclerforProbidan(getContext(), "AdmissionInfo", binding.recyclerViewProbidan);
setAdminWork(binding.addProbidan);
        binding.addProbidan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetProbidan(getContext(), uploadProbidan.class,"AdmissionInfo","");
            }
        });
        return binding.getRoot();
    }
    @Override
    public void onResume() {
        super.onResume();
        NoInternetSnackbar.Builder builder2 = new NoInternetSnackbar.Builder(getActivity(), (ViewGroup) getActivity().findViewById(android.R.id.content));

        builder2.setConnectionCallback(new ConnectionCallback() { // Optional
            @Override
            public void hasActiveConnection(boolean hasActiveConnection) {
                // ...
            }
        });
        builder2.setIndefinite(true); // Optional
        builder2.setNoInternetConnectionMessage("No active Internet connection!"); // Optional
        builder2.setOnAirplaneModeMessage("You have turned on the airplane mode!"); // Optional
        builder2.setSnackbarActionText("Settings");
        builder2.setShowActionToDismiss(false);
        builder2.setSnackbarDismissActionText("OK");

        noInternetSnackbar = builder2.build();

    }

    @Override
    public void onPause() {

        // No Internet Snackbar
        if (noInternetSnackbar != null) {
            noInternetSnackbar.destroy();
        }
        super.onPause();


    }
}