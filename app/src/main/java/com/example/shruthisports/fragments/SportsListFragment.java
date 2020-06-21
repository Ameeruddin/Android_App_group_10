package com.example.shruthisports.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shruthisports.R;
import com.example.shruthisports.Sports;
import com.example.shruthisports.adapters.SportsAdapter;

import java.util.ArrayList;

public class SportsListFragment extends Fragment {

    ListView listView;
    ArrayList<Sports> sportsList = new ArrayList<>();
    Context mContext;

    public SportsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sports_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for(int i=0;i<10;i++){
            Sports s = new Sports((long)i+5,"sport"+i,"indoor",i,i+5);
            sportsList.add(s);
        }
        listView = view.findViewById(R.id.listView);
        if(sportsList.isEmpty()){
            Toast.makeText(mContext,"No items in sports", Toast.LENGTH_LONG).show();
        }else {
            SportsAdapter adapter = new SportsAdapter(mContext, R.layout.sports, sportsList);
            listView.setAdapter(adapter);
        }
    }
}