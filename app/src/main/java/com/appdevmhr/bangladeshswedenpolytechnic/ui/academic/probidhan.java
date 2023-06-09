package com.appdevmhr.bangladeshswedenpolytechnic.ui.academic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentProbidhanBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;
import com.appdevmhr.bangladeshswedenpolytechnic.ui.department.TeacherView;
import com.appdevmhr.bangladeshswedenpolytechnic.ui.setPeople;
import com.appdevmhr.bangladeshswedenpolytechnic.uploadProbidan;
import com.rajat.pdfviewer.PdfViewerActivity;

import org.imaginativeworld.oopsnointernet.NoInternetSnackbar;


public class probidhan extends Fragment implements simpleMethod {

    FragmentProbidhanBinding binding;
    NoInternetSnackbar noInternetSnackbar;
    public probidhan() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProbidhanBinding.inflate(inflater, container, false);
        setFirestoreRecyclerforProbidan(getContext(), "Probidan", binding.recyclerViewProbidan);

        binding.addProbidan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setIntentForSetProbidan(getContext(), uploadProbidan.class,"Probidan","");
            }
        });
//        binding.probidan22.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(PdfViewerActivity.Companion.launchPdfFromUrl(getContext(),"https://firebasestorage.googleapis.com/v0/b/bangladeshswedenpolytechnic.appspot.com/o/probidan%2F_%E0%A6%A1%E0%A6%BF%E0%A6%AA%E0%A7%8D%E0%A6%B2%E0%A7%8B%E0%A6%AE%E0%A6%BE%20%E0%A6%87%E0%A6%A8%20%E0%A6%87%E0%A6%9E%E0%A7%8D%E0%A6%9C%E0%A6%BF%E0%A6%A8%E0%A6%BF%E0%A6%AF%E0%A6%BC%E0%A6%BE%E0%A6%B0%E0%A6%BF%E0%A6%82%20%E0%A6%AA%E0%A7%8D%E0%A6%B0%E0%A6%AC%E0%A6%BF%E0%A6%A7%E0%A6%BE%E0%A6%A8-%E0%A7%A8%E0%A7%A6%E0%A7%A8%E0%A7%A8.pdf?alt=media&token=ea569f2f-1395-460b-b024-d57f1d6dcc59","প্রবিধান -২০২২","",true));
//            }
//        });
//        binding.probidan16.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(PdfViewerActivity.Companion.launchPdfFromUrl(getContext(),"https://firebasestorage.googleapis.com/v0/b/bangladeshswedenpolytechnic.appspot.com/o/probidan%2FDiplomaEnggProbidhan_2016.pdf?alt=media&token=79ed31a8-d379-47c2-b269-8be86bdf61de","প্রবিধান -২০১৬","",true));
//
//            }
//        });
//        binding.probidan10.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(PdfViewerActivity.Companion.launchPdfFromUrl(getContext(),"https://firebasestorage.googleapis.com/v0/b/bangladeshswedenpolytechnic.appspot.com/o/probidan%2Fprobidan_2010.pdf?alt=media&token=90f59a8c-c098-4c97-bc33-71aeb78ac741","প্রবিধান -২০১০","",true));
//
//            }
//        });
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        setNoInternetSnackbar(getActivity(),noInternetSnackbar);
    }
}