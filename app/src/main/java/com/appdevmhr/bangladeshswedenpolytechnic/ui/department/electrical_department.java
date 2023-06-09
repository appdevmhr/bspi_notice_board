package com.appdevmhr.bangladeshswedenpolytechnic.ui.department;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentElectricalDepartmentBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;

public class electrical_department extends Fragment implements simpleMethod {
    FragmentElectricalDepartmentBinding binding;


    public electrical_department() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentElectricalDepartmentBinding.inflate(inflater, container, false);
        binding.OurTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "etTeachers", "");
            }
        });
        binding.StaffList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "etStaffList", "");
            }
        });
        binding.ourTeacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "etTeachers", "");
            }
        });
        binding.staffListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "etStaffList", "");
            }
        });

        return binding.getRoot();
    }
}