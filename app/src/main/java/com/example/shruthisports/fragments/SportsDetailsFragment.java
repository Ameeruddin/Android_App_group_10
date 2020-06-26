package com.example.shruthisports.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.shruthisports.R;
import com.example.shruthisports.adapters.SportsListDetailsAdapter;
import com.example.shruthisports.classes.Sports;
import com.example.shruthisports.classes.SportsListDetails;
import com.example.shruthisports.classes.SportsListHeading;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SportsDetailsFragment extends Fragment {

    ListView listView;
    ArrayList<Sports> sportsList = new ArrayList<>();
    ArrayList<String> sportNames = new ArrayList<>();
    ArrayList<SportsListHeading> scheduledSports;
    Context mContext;
    SharedPreferences userPref;

    //creating objects required to interact with REST api
    private RequestQueue queue;
    JsonArrayRequest arrayRequest;
    JSONObject data;

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

        scheduledSports = new ArrayList<>();

        userPref = getActivity().getSharedPreferences("user",Context.MODE_PRIVATE);
        final String accessTkn = userPref.getString("access_token","");

        String url = "https://group-10-user-api.herokuapp.com/sportdetails";
        queue = Volley.newRequestQueue(mContext);
        arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONArray>() {
                        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                        @Override
                        public void onResponse(JSONArray response) {
                            try {
                                JSONArray array= new JSONArray(response);
                                for(int i=0;i<array.length();i++) {

                                    JSONObject sport = array.getJSONObject(i);

                                    String sportName = sport.getString("sport_name");
                                    String sportCategory = sport.getString("sport_category");
                                    Integer minTeamSize = sport.getInt("mini_team_size");
                                    Integer maxTeamSize = sport.getInt("max_team_size");
                                    String gender = sport.getString("gender");
                                    String startDate = sport.getString("start_date");
                                    String endDate = sport.getString("end_date");

                                    ArrayList<SportsListDetails> details = new ArrayList<>();
                                    if (sportCategory != null) {
                                        if (gender != null) {
                                            details.add(new SportsListDetails("Category: " + sportCategory + " (" + gender + ")"));
                                        } else {
                                            details.add(new SportsListDetails("Category: " + sportCategory));
                                        }
                                    }
                                    if (minTeamSize != null && maxTeamSize != null) {
                                        details.add(new SportsListDetails("Team Size: " + minTeamSize + "-" + maxTeamSize));
                                    }
                                    if (startDate != null) {
                                        details.add(new SportsListDetails("Start Date: " + startDate));
                                    }
                                    if (endDate != null) {
                                        details.add(new SportsListDetails("End Date: " + endDate));
                                    }
                                    details.add(new SportsListDetails("Hello"));
                                    SportsListHeading sportsListHeading = new SportsListHeading(sportName, details);
                                    scheduledSports.add(sportsListHeading);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(mContext, error.toString()+accessTkn, Toast.LENGTH_LONG).show();
                        }
                    }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Authorization","Bearer "+accessTkn);
                    return params;
                }
            };
            queue.add(arrayRequest);
        //remove later
        ArrayList<SportsListDetails> basketballDetails = new ArrayList<>();
        basketballDetails.add(new SportsListDetails("mno"));
        basketballDetails.add(new SportsListDetails("pqr"));
        SportsListHeading basketball = new SportsListHeading("basketball",basketballDetails);
        scheduledSports.add(basketball);

        SportsListDetailsAdapter adapter = new SportsListDetailsAdapter(scheduledSports);
        matchDetailsRecyclerView.setAdapter(adapter);
    }
}