package com.appdevmhr.bangladeshswedenpolytechnic.ui.department;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appdevmhr.bangladeshswedenpolytechnic.R;
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentNonTechDepartmentBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;

public class non_tech_department extends Fragment implements simpleMethod {


    public non_tech_department() {

    }
FragmentNonTechDepartmentBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNonTechDepartmentBinding.inflate(inflater, container, false);
        binding.OurTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "ntTeachers", "");
            }
        });
        binding.StaffList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "ntStaffList", "");
            }
        });
        binding.ourTeacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "ntTeachers", "");
            }
        });
        binding.staffListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "ntStaffList", "");
            }
        });
        return binding.getRoot();


    }}