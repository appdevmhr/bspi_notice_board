package com.appdevmhr.bangladeshswedenpolytechnic.ui.administation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentOfficalStaffBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;
import com.appdevmhr.bangladeshswedenpolytechnic.ui.setPeople;


public class offical_staff extends Fragment implements simpleMethod {


    FragmentOfficalStaffBinding binding;


    public offical_staff() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentOfficalStaffBinding.inflate(inflater, container, false);
        setFirestoreRecycler(getContext(), "officeStaffInfo", binding.simpleStaffListRecyclerView);
        setAdminWork(binding.floatingActionButton);
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getContext(), setPeople.class,"officeStaffInfo","");
            }
        });

        return binding.getRoot();
    }



}