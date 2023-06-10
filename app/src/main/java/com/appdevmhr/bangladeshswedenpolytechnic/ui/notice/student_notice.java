package com.appdevmhr.bangladeshswedenpolytechnic.ui.notice;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appdevmhr.bangladeshswedenpolytechnic.R;
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentStudentNoticeBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;
import com.appdevmhr.bangladeshswedenpolytechnic.uploadProbidan;


public class student_notice extends Fragment implements simpleMethod {


    FragmentStudentNoticeBinding binding;
    public student_notice() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentStudentNoticeBinding.inflate(inflater,container,false);
        setFirestoreRecyclerforProbidan(getContext(), "Student_Notice", binding.recyclerViewProbidan);

        binding.addProbidan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetProbidan(getContext(), uploadProbidan.class,"Student_Notice","");
            }
        });
        setAdminWork(binding.addProbidan);
        return binding.getRoot();
    }
}