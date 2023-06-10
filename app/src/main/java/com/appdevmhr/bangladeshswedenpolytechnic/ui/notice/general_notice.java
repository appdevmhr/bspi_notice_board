package com.appdevmhr.bangladeshswedenpolytechnic.ui.notice;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appdevmhr.bangladeshswedenpolytechnic.R;
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentGeneralNoticeBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;
import com.appdevmhr.bangladeshswedenpolytechnic.uploadProbidan;

public class general_notice extends Fragment implements simpleMethod {

    FragmentGeneralNoticeBinding binding;
    public general_notice() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGeneralNoticeBinding.inflate(inflater,container,false);
        setFirestoreRecyclerforProbidan(getContext(), "General_Notice", binding.recyclerViewProbidan);

        binding.addProbidan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForSetProbidan(getContext(), uploadProbidan.class,"General_Notice","");
            }
        });
        return binding.getRoot();
    }
}