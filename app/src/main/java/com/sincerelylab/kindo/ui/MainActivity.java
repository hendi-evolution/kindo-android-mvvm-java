package com.sincerelylab.kindo.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sincerelylab.kindo.R;
import com.sincerelylab.kindo.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        //return handleNavigationSelection(item.getItemId());
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // ini fragment
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag("homeFragmentTag");
        if (fragment == null) {
            FragmentTransaction ft = fm.beginTransaction();
            fragment = new HomeFragment();
            ft.replace(R.id.tab_container, fragment, "homeFragmentTag");
            ft.commit();
        }
    }

    private boolean handleNavigationSelection(int id) {
//        switch (id) {
//            case R.id.navigation_home:
//                return true;
//            case R.id.navigation_dashboard:
//                return true;
//            case R.id.navigation_notifications:
//                return true;
//        }
//        return false;

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag("homeFragmentTag");
        if (fragment == null) {
            FragmentTransaction ft = fm.beginTransaction();
            fragment = new HomeFragment();
            ft.replace(R.id.tab_container, fragment, "homeFragmentTag");
            ft.commit();
        }
        return true;
    }
}
