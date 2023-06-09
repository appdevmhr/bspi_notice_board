package com.appdevmhr.bangladeshswedenpolytechnic.ui.academic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentLibraryBinding;

import org.imaginativeworld.oopsnointernet.ConnectionCallback;
import org.imaginativeworld.oopsnointernet.NoInternetSnackbar;

public class library extends Fragment {


    FragmentLibraryBinding binding;
    NoInternetSnackbar noInternetSnackbar;
    public library() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLibraryBinding.inflate(inflater, container, false);
        binding.webview.loadUrl("https://bspi.btebsys.com/library/");
        binding.webview.setWebViewClient(new WebViewClient());
        binding.webview.getSettings().setLoadsImagesAutomatically(true);
        binding.webview.getSettings().setJavaScriptEnabled(true);
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