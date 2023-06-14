package com.appdevmhr.bangladeshswedenpolytechnic.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appdevmhr.bangladeshswedenpolytechnic.FolderList;
import com.appdevmhr.bangladeshswedenpolytechnic.R;
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentAlbumBinding;
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod;
import com.appdevmhr.bangladeshswedenpolytechnic.uploadFolder;


public class album extends Fragment implements simpleMethod {


    FragmentAlbumBinding binding;
    public album() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding = FragmentAlbumBinding.inflate(inflater,container,false);
        binding.addStudentInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntentForFolderupload(getContext(), uploadFolder.class,"Gallary_Folder_list");
            }
        });
        setAdminWork(binding.addStudentInfo);
        setFirestoreRecyclerforFolderUpload(getContext(), "Gallary_Folder_list", binding.recyclerViewStudentInfo,"StudentInfo");

        return binding.getRoot();
    }
}