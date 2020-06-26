package com.example.shruthisports.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.shruthisports.R;
import com.example.shruthisports.classes.SportsListHeading;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SportsDetailsFragment extends Fragment {

    ListView listView;
    ArrayList<SportsListHeading> scheduledSports;
    Context mContext;
    SharedPreferences userPref;

    //creating objects required to interact with REST api
    static String accessTkn;
    private RequestQueue queue;
    JsonArrayRequest arrayRequest;
    JSONArray data;

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

        userPref = getActivity().getSharedPreferences("user",Context.MODE_PRIVATE);
        accessTkn = userPref.getString("access_token","");

        String url = "https://group-10-user-api.herokuapp.com/sportdetails";
        queue = Volley.newRequestQueue(mContext);
        data = new JSONArray();

        try {
            //data.put(new String[]{"sport_name", "cricket"});
        }catch (Exception e){
            Toast.makeText(mContext, "error 1",Toast.LENGTH_LONG).show();
        }
        arrayRequest = new JsonArrayRequest(Request.Method.GET, url, data,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    Toast.makeText(mContext, response.getJSONObject(1).toString(),Toast.LENGTH_LONG).show();
//                    String k = response.getString("gender");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "Bearer "+accessTkn);
                return params;
            }
        };
        queue.add(arrayRequest);
    }
}