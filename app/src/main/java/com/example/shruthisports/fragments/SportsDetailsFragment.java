package com.example.shruthisports.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.shruthisports.R;
import com.example.shruthisports.classes.SportsListDetails;
import com.example.shruthisports.adapters.SportsListDetailsAdapter;
import com.example.shruthisports.classes.SportsListHeading;
import com.example.shruthisports.classes.Sports;

import java.util.ArrayList;

public class SportsDetailsFragment extends Fragment {

    ListView listView;
    ArrayList<Sports> sportsList = new ArrayList<>();
    Context mContext;

    public SportsDetailsFragment() {
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
        return inflater.inflate(R.layout.fragment_sports_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView matchDetailsRecyclerView = view.findViewById(R.id.MatchDetailsRecyclerView);
        matchDetailsRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        ArrayList<SportsListHeading> scheduledSports = new ArrayList<>();

        ArrayList<SportsListDetails> footballDetails = new ArrayList<>();
        footballDetails.add(new SportsListDetails("abc"));
        footballDetails.add(new SportsListDetails("def"));
        SportsListHeading football = new SportsListHeading("Football",footballDetails);
        scheduledSports.add(football);

        ArrayList<SportsListDetails> cricketDetails = new ArrayList<>();
        cricketDetails.add(new SportsListDetails("ghi"));
        cricketDetails.add(new SportsListDetails("jkl"));
        SportsListHeading cricket = new SportsListHeading("Cricket",cricketDetails);
        scheduledSports.add(cricket);

        ArrayList<SportsListDetails> basketballDetails = new ArrayList<>();
        basketballDetails.add(new SportsListDetails("mno"));
        basketballDetails.add(new SportsListDetails("pqr"));
        SportsListHeading basketball = new SportsListHeading("basketball",basketballDetails);
        scheduledSports.add(basketball);

        SportsListDetailsAdapter adapter = new SportsListDetailsAdapter(scheduledSports);
        matchDetailsRecyclerView.setAdapter(adapter);
    }
}