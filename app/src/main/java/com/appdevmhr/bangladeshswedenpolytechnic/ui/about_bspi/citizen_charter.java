package com.appdevmhr.bangladeshswedenpolytechnic.ui.about_bspi;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appdevmhr.bangladeshswedenpolytechnic.R;
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentCitizenCharterBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;
import com.appdevmhr.bangladeshswedenpolytechnic.uploadProbidan;


public class citizen_charter extends Fragment implements simpleMethod {


    public citizen_charter() {
        // Required empty public constructor
    }

   FragmentCitizenCharterBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCitizenCharterBinding.inflate(inflater,container,false);
        setFirestoreRecyclerforProbidan(getContext(), "CITIZEN_CHARTER", binding.recyclerViewProbidan);

        setAdminWork(binding.addProbidan);
        binding.addProbidan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetProbidan(getContext(), uploadProbidan.class,"CITIZEN_CHARTER","");
            }
        });
        return binding.getRoot();
    }
}