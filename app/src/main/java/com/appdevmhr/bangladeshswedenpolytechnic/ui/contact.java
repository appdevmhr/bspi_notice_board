package com.appdevmhr.bangladeshswedenpolytechnic.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appdevmhr.bangladeshswedenpolytechnic.R;
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentContactBinding;
import com.squareup.picasso.Picasso;


public class contact extends Fragment {

   FragmentContactBinding binding;
    public contact() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentContactBinding.inflate(inflater,container,false);

        binding.imageView6.setImageResource(R.drawable.developer);
//        binding.name.setText("Mahmudul Hasan");
//        binding.Designation.setText("Software Developer");
//        binding.Section.setText("Developer");
//        binding.HomeDistrict.setText("Noakhali");
//        binding.Education.setText("Diploma In Computer Science And Technology");
//        binding.GovtJobJoiningDate.setVisibility(View.GONE);
//        binding.CurrentPositionJoinningDate.setVisibility(View.GONE);
//        binding.CurrentInstituteJoinningDate.setVisibility(View.GONE);
//        binding.Mobile.setText("+88" + "01537749454");
//        binding.Email.setText("appdevmhr@gmail.com");
//        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bangladeshswedenpolytechnic.appspot.com/o/cwtTeachers%2FMohammad%20Abdul%20Matin%20Howlader%20?alt=media&token=9d0d5ee5-358f-4af8-9973-c5e2782fefe6").placeholder(R.drawable.ic_baseline_account_circle_24).into(binding.imageView6);

        return binding.getRoot();
    }
}