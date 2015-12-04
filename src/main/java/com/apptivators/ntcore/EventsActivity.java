package com.apptivators.ntcore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.apptivators.ntcore.Models.Trip;
import com.apptivators.ntcore.Models.TripType;
import com.apptivators.ntcore.Utils.F;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class EventsActivity  extends Fragment
{
    ListView listView;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        //GET VIEW CACHED VARIABLES
        View view = inflater.inflate(R.layout.event_list_main_view, container, false);
        listView = (ListView) view.findViewById(R.id.listViewFood);
        String mTitle = getArguments().getString("title");

        //SET THE ACTIONBAR TITLE & ICON
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(mTitle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //POPULATE THE LIST VIEW
        /*if(mTitle=="Featured Events") {
            F.GetTrips(TripType.FEATURED);
            events = new String[]{"Featured Event I ", "Featured Event II ", "Featured Event III ", "Featured Event IV ", "Featured Event V ", "Featured Event VI ", "Featured Event VII ", "Featured Event VIII ", "Featured Event IX ", "Featured Event X"};
        }
        else if(mTitle=="Adventure Events")
            events = new String[] {"Adventure Rafting","Adventure mela","Adventure water Rafting","Adventure Rafting","Raft Nepal 2015","Canoning","Global Rafting","Rafting for a cause","Keep Rafting","Raft Today"};
        else if(mTitle=="Casual Events")
            events = new String[] {"Causel Walking","Rafting mela","White water Rafting","Sunshine Rafting","Raft Nepal 2015","Canoning","Global Rafting","Rafting for a cause","Keep Rafting","Raft Today"};
        else if(mTitle=="Exploring Events")
            events = new String[] {"Explore treasure","Rafting mela","White water Rafting","Sunshine Rafting","Raft Nepal 2015","Canoning","Global Rafting","Rafting for a cause","Keep Rafting","Raft Today"};
        else if(mTitle=="Mountaineering Events")
            events = new String[] {"ABC","Rafting mela","White water Rafting","Sunshine Rafting","Raft Nepal 2015","Canoning","Global Rafting","Rafting for a cause","Keep Rafting","Raft Today"};
        else if(mTitle=="Hiking Events")
            events = new String[] {"Sindhulli Hiking","Rafting mela","White water Rafting","Sunshine Rafting","Raft Nepal 2015","Canoning","Global Rafting","Rafting for a cause","Keep Rafting","Raft Today"};
        else if(mTitle=="Romantic Events")
            events = new String[] {"Pokhara Tour","Rafting mela","White water Rafting","Sunshine Rafting","Raft Nepal 2015","Canoning","Global Rafting","Rafting for a cause","Keep Rafting","Raft Today"};
        else
            events = new String[] {"Trisuli Rafting","Rafting mela","White water Rafting","Sunshine Rafting","Raft Nepal 2015","Canoning","Global Rafting","Rafting for a cause","Keep Rafting","Raft Today"};

*/

        //TODO: TAKES ABOUT 3-4 SECONDS, SO A PROGRESSBAR OR PROGRESSDIALOG WOULD BE NICE HERE


        // Fetch data from firebase and populate the listview
        Firebase eventsRef = new Firebase(F.rootNode + F.eventsRefNode);
        eventsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Trip> trips = new ArrayList<Trip>();
                for(DataSnapshot trip: dataSnapshot.getChildren())
                {
                    Trip t = trip.getValue(Trip.class);
                    t.ID = trip.getKey();
                    trips.add(t);
                }
                ListAdapter listAdp = new CustomAdapter(getActivity(), trips,R.layout.event_list_single_view);
                listView.setAdapter(listAdp);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Trip curItem =  (Trip)(parent.getItemAtPosition(position));
                        Toast.makeText(getActivity(), curItem.getTitle(), Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getActivity(), EventDetailActivity.class);
                        Bundle b = new Bundle();
                        b.putSerializable("curTrip",curItem);
                        i.putExtras(b);
                        startActivity(i);
                    }
                }
        );
        return view;
    }
}
