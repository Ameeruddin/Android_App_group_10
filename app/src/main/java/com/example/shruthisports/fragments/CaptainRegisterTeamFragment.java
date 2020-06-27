package com.example.shruthisports.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shruthisports.R;
import com.example.shruthisports.activities.RegisterTeamActivity;

public class CaptainRegisterTeamFragment extends Fragment {

    Context mContext;
    Button registerTeamBtn;
    Spinner sportsSpinner;
    Spinner branchSpinner;
    Spinner sectionSpinner;
    RadioGroup genderGroup;

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
        branchSpinner = view.findViewById(R.id.branchSpinner);
        sectionSpinner = view.findViewById(R.id.sectionSpinner);
        genderGroup = view.findViewById(R.id.genderRB);

        final String sportName = sportsSpinner.getSelectedItem().toString();
        final String branch = branchSpinner.getSelectedItem().toString();
        final int section = Integer.parseInt(sectionSpinner.getSelectedItem().toString());
        int genderNum = genderGroup.getCheckedRadioButtonId();
        final String gender;
        if(genderNum==0){
            gender="MALE";
        }else{
            gender="FEMALE";
        }

        ArrayAdapter adapter = new ArrayAdapter<>(mContext, R.layout.support_simple_spinner_dropdown_item, sportsArray);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        sportsSpinner.setAdapter(adapter);

        registerTeamBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openregistration(sportName,branch,section,gender);
            }
        });
    }

    private void openregistration(String sportName, String branch, int section, String gender) {
        Intent intent = new Intent(mContext, RegisterTeamActivity.class);
        intent.putExtra("sportName",sportName);
        intent.putExtra("branch",branch);
        intent.putExtra("section",section);
        intent.putExtra("gender",gender);
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_captain_register_team, container, false);
    }
}