package com.appdevmhr.bangladeshswedenpolytechnic.ui.academic;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appdevmhr.bangladeshswedenpolytechnic.R;
import com.rajat.pdfviewer.PdfViewerActivity;

public class scholarship extends Fragment {

    public scholarship() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


         return inflater.inflate(R.layout.fragment_scholarship, container, false);
    }
}