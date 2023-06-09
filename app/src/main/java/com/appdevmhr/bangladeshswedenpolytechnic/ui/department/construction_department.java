package com.appdevmhr.bangladeshswedenpolytechnic.ui.department;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentConstructionDepartmentBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;

public class construction_department extends Fragment implements simpleMethod {


    FragmentConstructionDepartmentBinding binding;

    public construction_department() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentConstructionDepartmentBinding.inflate(inflater, container, false);
        binding.OurTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "contTeachers", "");
            }
        });
        binding.StaffList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "contStaffList", "");
            }
        });
        binding.ourTeacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "contTeachers", "");
            }
        });
        binding.staffListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "contStaffList", "");
            }
        });

        return binding.getRoot();
    }
}