package com.appdevmhr.bangladeshswedenpolytechnic.ui.department;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appdevmhr.bangladeshswedenpolytechnic.R;
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentMechanicalDepartmentBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;


public class mechanical_department extends Fragment implements simpleMethod {

    public mechanical_department() {
        // Required empty public constructor
    }

   FragmentMechanicalDepartmentBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMechanicalDepartmentBinding.inflate(inflater, container, false);
        binding.OurTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class,"mtTeachers","");
            }
        });
        binding.StaffList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(),TeacherView.class,"mtStaffList","");
            }
        });
        binding.ourTeacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "mtTeachers", "");
            }
        });
        binding.staffListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetPeaple(getActivity(), TeacherView.class, "mtStaffList", "");
            }
        });

        return binding.getRoot();
    }
}