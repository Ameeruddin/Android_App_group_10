package com.example.shruthisports.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.shruthisports.CaptainMatchFragment;
import com.example.shruthisports.R;
import com.example.shruthisports.fragments.CaptainRegisterTeamFragment;
import com.example.shruthisports.fragments.HomeFragment;
import com.example.shruthisports.fragments.LogoutFragment;
import com.example.shruthisports.fragments.ProfileFragment;
import com.google.android.material.navigation.NavigationView;

public class CaptainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout captainDrawerLayout;
    NavigationView captainNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captain);

        Toolbar captainToolbar = findViewById(R.id.captain_toolbar);
        setSupportActionBar(captainToolbar);

        captainDrawerLayout = findViewById(R.id.captain_drawer_layout);
        captainNavigationView = findViewById(R.id.captain_nav_view);
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
    public void onBackPressed() {
        if(captainDrawerLayout.isDrawerOpen(GravityCompat.START)){
            captainDrawerLayout.closeDrawer(GravityCompat.START);
        }else if(getCheckedItem(captainNavigationView)==0){
            return;
        }else{
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            captainNavigationView.setCheckedItem(R.id.nav_home);
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
            case R.id.captain_nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.captain_fragment_container,
                        new ProfileFragment()).commit();
                break;
            case R.id.captain_nav_logout:
                getSupportFragmentManager().beginTransaction().replace(R.id.captain_fragment_container,
                        new LogoutFragment()).commit();
                break;
            case R.id.captain_nav_schedules:
                getSupportFragmentManager().beginTransaction().replace(R.id.captain_fragment_container,
                        new CaptainMatchFragment()).commit();
                break;
        }
        captainDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private int getCheckedItem(NavigationView navigationView) {
        Menu menu = navigationView.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            if (item.isChecked()) {
                return i;
            }
        }
        return -1;
    }
}
