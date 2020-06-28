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

public class CaptainHomeFragment extends Fragment {

    Context mContext;
    Button captainMatchSchedulesBtn;
    Button captainRegistrationStatusBtn;
    Button captainRegisteredSportsBtn;
    Button captainCaptainProfileBtn;
    Button captainRegisterTeamBtn;
    Button captainSettingsBtn;
    Button captainLogoutBtn;
    Toolbar captainToolbar;
    NavigationView navigationView;

    public CaptainHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navigationView = getActivity().findViewById(R.id.captain_nav_view);
        captainToolbar = getActivity().findViewById(R.id.captain_toolbar);

        captainMatchSchedulesBtn = view.findViewById(R.id.captain_match_schedules_btn);
        captainRegistrationStatusBtn = view.findViewById(R.id.captain_registration_status_btn);
        captainRegisteredSportsBtn = view.findViewById(R.id.captain_registered_sports_btn);
        captainCaptainProfileBtn = view.findViewById(R.id.captain_captain_profile_btn);
        captainRegisterTeamBtn = view.findViewById(R.id.captain_register_team_btn);
        captainSettingsBtn = view.findViewById(R.id.captain_settings_btn);
        captainLogoutBtn = view.findViewById(R.id.captain_logout_btn);

        captainMatchSchedulesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setCheckedItem(R.id.captain_nav_schedules);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.captain_fragment_container,
                        new CaptainMatchFragment()).commit();
                captainToolbar.setTitle("Match Schedules");
            }
        });

        captainRegistrationStatusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setCheckedItem(R.id.captain_nav_status);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.captain_fragment_container,
                        new TeamStatusFragment()).commit();
                captainToolbar.setTitle("Registration Status");
            }
        });

        captainRegisteredSportsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setCheckedItem(R.id.captain_nav_registered);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.captain_fragment_container,
                        new CaptainRegisteredSportsFragment()).commit();
                captainToolbar.setTitle("Registered Sports");
            }
        });

        captainCaptainProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setCheckedItem(R.id.captain_nav_profile);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.captain_fragment_container,
                        new ProfileFragment()).commit();
                captainToolbar.setTitle("Captain Profile");
            }
        });

        captainRegisterTeamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setCheckedItem(R.id.captain_nav_register);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.captain_fragment_container,
                        new CaptainRegisterTeamFragment()).commit();
                captainToolbar.setTitle("Register Team");
            }
        });

        captainSettingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setCheckedItem(R.id.captain_nav_settings);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.captain_fragment_container,
                        new SettingsFragment()).commit();
                captainToolbar.setTitle("Settings");
            }
        });

        captainLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setCheckedItem(R.id.captain_nav_logout);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.captain_fragment_container,
                        new LogoutFragment()).commit();
                captainToolbar.setTitle("Logout");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_captain_home, container, false);
    }
}