package com.appdevmhr.bangladeshswedenpolytechnic.ui.academic;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appdevmhr.bangladeshswedenpolytechnic.R;
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentAcademicCalenderBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;
import com.appdevmhr.bangladeshswedenpolytechnic.uploadProbidan;
import com.rajat.pdfviewer.PdfViewerActivity;

import org.imaginativeworld.oopsnointernet.NoInternetSnackbar;

public class academic_calender extends Fragment implements simpleMethod {


    public academic_calender() {
        // Required empty public constructor
    }

NoInternetSnackbar noInternetSnackbar;
    FragmentAcademicCalenderBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        binding = FragmentAcademicCalenderBinding.inflate(inflater, container, false);


        setFirestoreRecyclerforProbidan(getContext(), "Academic_Calender", binding.recyclerViewProbidan);

        binding.addProbidan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetProbidan(getContext(), uploadProbidan.class,"Academic_Calender","");
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        setNoInternetSnackbar(getActivity(),noInternetSnackbar);
    }

    @Override
    public void onPause() {
        super.onPause();
        destroyInternetSnackbar(noInternetSnackbar);
    }

}