package com.example.shruthisports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.shruthisports.adapters.SportsListDetailsAdapter;
import com.example.shruthisports.classes.SportsListDetails;
import com.example.shruthisports.classes.SportsListHeading;

import java.util.ArrayList;

public class MatchSchedulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_schedules);

        RecyclerView matchDetailsRecyclerView = findViewById(R.id.MatchDetailsRecyclerView);
        matchDetailsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

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