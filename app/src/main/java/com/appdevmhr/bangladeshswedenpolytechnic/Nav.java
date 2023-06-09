package com.appdevmhr.bangladeshswedenpolytechnic;

import android.os.Bundle;
import android.view.Menu;

import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivityNavBinding;

public class Nav extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
private ActivityNavBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityNavBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNav.toolbar);
//        binding.appBarNav.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.principal, R.id.vice_principal,R.id.academic_council,R.id.administrative_council,R.id.exam_control_section,R.id.offical_staff,R.id.bspi_student_penel,R.id.online_campus,R.id.library,R.id. admission_info,R.id .job_placement_cell,R.id.probidhan ,R.id. academic_calender,R.id. computer_department,R.id.automobile_department ,R.id.civilwood_department ,R.id.construction_department ,R.id.electrical_department ,R.id.mechanical_department ,R.id. non_tech_department,R.id. general_notice,R.id.student_notice ,R.id. tender_notice,R.id.principal_message ,R.id.vice_principal_message ,R.id.history_background ,R.id.mission_vission ,R.id.citizen_charter ,R.id. hostel,R.id. organogram,R.id. bspiofficial,R.id. album,R.id. contact)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nav);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nav);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}