package com.bunty.blackbnstructure.ui.activity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.bunty.blackbnstructure.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;


public class MainActivity extends AppCompatActivity {


    BottomNavigationView mBottomNav;
    NavHostFragment mNavHostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews() {

        mBottomNav = findViewById(R.id.btn_nav_view);
        mNavHostFragment =  (NavHostFragment)getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(mBottomNav,
                mNavHostFragment.getNavController());
        NavigationUI.setupActionBarWithNavController(this, mNavHostFragment.getNavController());

    }

    @Override
    public boolean onSupportNavigateUp() {
        return mNavHostFragment.getNavController().navigateUp();
    }
}
