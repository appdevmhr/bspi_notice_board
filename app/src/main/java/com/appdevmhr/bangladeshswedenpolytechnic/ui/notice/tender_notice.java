package com.appdevmhr.bangladeshswedenpolytechnic.ui.notice;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appdevmhr.bangladeshswedenpolytechnic.R;
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentTenderNoticeBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;
import com.appdevmhr.bangladeshswedenpolytechnic.uploadProbidan;

public class tender_notice extends Fragment implements simpleMethod {

    FragmentTenderNoticeBinding binding;

    public tender_notice() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTenderNoticeBinding.inflate(inflater,container,false);
        setFirestoreRecyclerforProbidan(getContext(), "Tender_Notice", binding.recyclerViewProbidan);

        setAdminWork(binding.addProbidan);
        binding.addProbidan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetProbidan(getContext(), uploadProbidan.class,"Tender_Notice","");
            }
        });
        return binding.getRoot();
    }
}