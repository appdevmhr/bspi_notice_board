package com.appdevmhr.bangladeshswedenpolytechnic.ui.administation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.appdevmhr.bangladeshswedenpolytechnic.FullViewImage;
import com.appdevmhr.bangladeshswedenpolytechnic.R;
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentPrincipalBinding;
import com.squareup.picasso.Picasso;

public class principal extends Fragment {
    FragmentPrincipalBinding binding;
    public principal() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPrincipalBinding.inflate(inflater,container,false);
        binding.name.setText("MOHAMMAD ABDUL MATIN HOWLADER");
        binding.Designation.setText("Designation : " + "Principal ");
        binding.Section.setText("Register");
        binding.HomeDistrict.setText("Rangamati Hill Tracks");
        binding.Education.setText("B.Sc in Technical Education (Civil Engineering)");
        binding.GovtJobJoiningDate.setText("16-02-1993");
        binding.CurrentPositionJoinningDate.setText("20-06-2019");
        binding.CurrentInstituteJoinningDate.setText("20-06-2019");
        binding.Mobile.setText("+88" + "01827557761");
        binding.Email.setText("principal.bspi@yahoo.com");
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bangladeshswedenpolytechnic.appspot.com/o/cwtTeachers%2FMohammad%20Abdul%20Matin%20Howlader%20?alt=media&token=9d0d5ee5-358f-4af8-9973-c5e2782fefe6").placeholder(R.drawable.ic_baseline_account_circle_24).into(binding.imageView6);

        binding.Mobile.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String url = "https://api.whatsapp.com/send?phone="+"+88"+"01827557761";
                Intent whatsapp = new Intent(Intent.ACTION_VIEW);
                whatsapp.setData(Uri.parse(url));
                startActivity(whatsapp);
                return false;
            }
        });
        binding.imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FullViewImage.class);
                intent.putExtra("photo","https://firebasestorage.googleapis.com/v0/b/bangladeshswedenpolytechnic.appspot.com/o/cwtTeachers%2FMohammad%20Abdul%20Matin%20Howlader%20?alt=media&token=9d0d5ee5-358f-4af8-9973-c5e2782fefe6");
                startActivity(intent);
            }
        });
        return binding.getRoot();
    }
}