package com.example.shruthisports.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.shruthisports.R;
import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment {

    Context mContext;
    Button homeSportsSchedulesBtn;
    Button homeRegisterTeamBtn;
    Button homeCaptainLoginBtn;
    Button homeUserProfileBtn;
    Button homeSportsDetailsBtn;
    Button homeSettingsBtn;
    Button homeLogoutBtn;
    NavigationView navigationView;
    Toolbar toolbar;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navigationView = getActivity().findViewById(R.id.nav_view);
        toolbar = getActivity().findViewById(R.id.toolbar);
        homeSportsSchedulesBtn = view.findViewById(R.id.home_sports_schedules_btn);
        homeRegisterTeamBtn = view.findViewById(R.id.home_register_team_btn);
        homeCaptainLoginBtn = view.findViewById(R.id.home_captain_login_btn);
        homeUserProfileBtn = view.findViewById(R.id.home_user_profile_btn);
        homeSportsDetailsBtn = view.findViewById(R.id.home_sports_details_btn);
        homeSettingsBtn = view.findViewById(R.id.home_settings_btn);
        homeLogoutBtn = view.findViewById(R.id.home_logout_btn);

        homeSportsSchedulesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setCheckedItem(R.id.nav_schedule);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ScheduleFragment()).commit();
                toolbar.setTitle("Sports Schedules");
            }
        });

        homeRegisterTeamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setCheckedItem(R.id.nav_register);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UserTeamRegisterFragment()).commit();
                toolbar.setTitle("Register Team");
            }
        });

        homeCaptainLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setCheckedItem(R.id.nav_captain_login);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LoginAsCaptainFragment()).commit();
                toolbar.setTitle("Login as Captain");
            }
        });

        homeUserProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setCheckedItem(R.id.nav_profile);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                toolbar.setTitle("User Profile");
            }
        });

        homeSportsDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setCheckedItem(R.id.nav_details);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SportsDetailsFragment()).commit();
                toolbar.setTitle("Sports Details");
            }
        });

        homeSettingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setCheckedItem(R.id.nav_settings);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                toolbar.setTitle("Settings");
            }
        });

        homeLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setCheckedItem(R.id.nav_logout);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LogoutFragment()).commit();
                toolbar.setTitle("Logout");
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
