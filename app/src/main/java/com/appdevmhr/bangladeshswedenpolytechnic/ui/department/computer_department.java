package com.appdevmhr.bangladeshswedenpolytechnic.ui.department;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentComputerDepartmentBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;

public class computer_department extends Fragment implements simpleMethod {

    public computer_department() {
        // Required empty public constructor
    }

FragmentComputerDepartmentBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentComputerDepartmentBinding.inflate(inflater, container, false);
        binding.OurTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "cstTeachers", "");
            }
        });
        binding.StaffList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "cstStaffList", "");
            }
        });
        binding.ourTeacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "cstTeachers", "");
            }
        });
        binding.staffListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "cstStaffList", "");
            }
        });


        return binding.getRoot();
    }
}