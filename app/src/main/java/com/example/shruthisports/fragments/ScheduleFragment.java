package com.example.shruthisports.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shruthisports.R;
import com.example.shruthisports.adapters.SportsAdapter;
import com.example.shruthisports.classes.Sports;

import java.util.ArrayList;

public class ScheduleFragment extends Fragment {

    ListView listView;
    ArrayList<Sports> sportsList = new ArrayList<>();
    Context mContext;

    public ScheduleFragment() {
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

        sportsList.add(new Sports((long) 1,"Football","Outdoor",11,15));
        sportsList.add(new Sports((long) 2,"Badminton","Indoor",4,6));
        sportsList.add(new Sports((long) 3,"Basketball","Outdoor",8,12));
        sportsList.add(new Sports((long) 4,"Cricket","Outdoor",11,15));
        sportsList.add(new Sports((long) 5,"Kabaddi","Indoor",7,11));
        sportsList.add(new Sports((long) 6,"Table Tennis","Indoor",4,7));
        sportsList.add(new Sports((long) 7,"Throwball","Outdoor",6,10));
        sportsList.add(new Sports((long) 8,"Volleyball","Outdoor",6,10));
        sportsList.add(new Sports((long) 9,"Chess","Indoor",4,6));
        sportsList.add(new Sports((long) 10,"Caroms","Indoor",4,6));

        listView = view.findViewById(R.id.listView);
        if(sportsList.isEmpty()){
            Toast.makeText(mContext,"No items in sports", Toast.LENGTH_LONG).show();
        }else {
            SportsAdapter adapter = new SportsAdapter(mContext, R.layout.sports, sportsList);
            listView.setAdapter(adapter);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }
}