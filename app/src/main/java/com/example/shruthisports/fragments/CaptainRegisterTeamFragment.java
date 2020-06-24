package com.example.shruthisports.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.shruthisports.R;
import com.example.shruthisports.activities.RegisterTeamActivity;

public class CaptainRegisterTeamFragment extends Fragment {

    Context mContext;
    Button registerTeamBtn;
    Spinner sportsSpinner;

    public CaptainRegisterTeamFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] sportsArray = getResources().getStringArray(R.array.sports_array);

        sportsSpinner = view.findViewById(R.id.sportsSpinner);
        registerTeamBtn = view.findViewById(R.id.teamRegisterBtn);

        ArrayAdapter adapter = new ArrayAdapter<>(mContext, R.layout.support_simple_spinner_dropdown_item, sportsArray);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        sportsSpinner.setAdapter(adapter);

        registerTeamBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openregistration();
            }
        });
    }

    private void openregistration() {
        Intent intent = new Intent(mContext, RegisterTeamActivity.class);
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_captain_register_team, container, false);
    }
}