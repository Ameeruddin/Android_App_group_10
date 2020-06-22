package com.example.shruthisports.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.shruthisports.fragments.CaptainRegisterTeamFragment;
import com.example.shruthisports.fragments.HomeFragment;
import com.example.shruthisports.R;
import com.google.android.material.navigation.NavigationView;

public class CaptainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout captainDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captain);

        Toolbar captainToolbar = findViewById(R.id.captain_toolbar);
        setSupportActionBar(captainToolbar);

        captainDrawerLayout = findViewById(R.id.captain_drawer_layout);
        NavigationView captainNavigationView = findViewById(R.id.captain_nav_view);
        captainNavigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, captainDrawerLayout, captainToolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        captainDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.captain_fragment_container,
                    new HomeFragment()).commit();
            captainNavigationView.setCheckedItem(R.id.captain_nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.captain_nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.captain_fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.captain_nav_register:
                getSupportFragmentManager().beginTransaction().replace(R.id.captain_fragment_container,
                        new CaptainRegisterTeamFragment()).commit();
                break;
        }
        captainDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(captainDrawerLayout.isDrawerOpen(GravityCompat.START)){
            captainDrawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
