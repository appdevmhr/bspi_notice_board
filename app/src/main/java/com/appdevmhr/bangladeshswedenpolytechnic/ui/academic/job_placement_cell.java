package com.appdevmhr.bangladeshswedenpolytechnic.ui.academic;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentJobPlacementCellBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;

import org.imaginativeworld.oopsnointernet.NoInternetSnackbar;

public class job_placement_cell extends Fragment implements simpleMethod {


    public job_placement_cell() {
        // Required empty public constructor
    }

    FragmentJobPlacementCellBinding binding;
    NoInternetSnackbar noInternetSnackbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentJobPlacementCellBinding.inflate(inflater, container, false);
        setWebview(binding.webview,"https://www.bspi.gov.bd/job-placement-cell");
        return binding.getRoot();

    }
    @Override
    public void onResume() {
        super.onResume();
       setNoInternetSnackbar(getActivity(),noInternetSnackbar);

    }

    @Override
    public void onPause() {

        // No Internet Snackbar
       destroyInternetSnackbar(noInternetSnackbar);
        super.onPause();


    }
}