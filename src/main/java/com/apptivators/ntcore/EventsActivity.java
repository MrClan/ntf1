package com.apptivators.ntcore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.apptivators.ntcore.Adapters.CityListAdapter;
import com.apptivators.ntcore.Models.City;
import com.apptivators.ntcore.Models.Trip;
import com.apptivators.ntcore.Models.TripType;
import com.apptivators.ntcore.Utils.F;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class EventsActivity extends Fragment {
    ListView listView;
    ProgressBar progressBar;
    String dataType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //GET VIEW CACHED VARIABLES
        View view = inflater.inflate(R.layout.event_list_main_view, container, false);
        listView = (ListView) view.findViewById(R.id.listViewFood);
        String mTitle = getArguments().getString("title");
        dataType = getArguments().getString("dataType");

        //SET THE ACTIONBAR TITLE & ICON
        //((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(mTitle);
        //((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //TODO: TAKES ABOUT 3-4 SECONDS, SO A PROGRESSBAR OR PROGRESSDIALOG WOULD BE NICE HERE
        LoadData();

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Trip curItem = (Trip) (parent.getItemAtPosition(position));
                        Toast.makeText(getActivity(), curItem.getTitle(), Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getActivity(), EventDetailActivity.class);
                        Bundle b = new Bundle();
                        b.putSerializable("curTrip", curItem);
                        i.putExtras(b);
                        startActivity(i);
                    }
                }
        );
        return view;
    }


    private void LoadData() {

        // Read from extras, and load data accordingly
        switch (dataType) {
            case "RomanticCities":
                LoadCities(TripType.ROMANTIC);
                break;
            case "Events":
            default:
                LoadEventsData();
                break;
        }
    }

    private void LoadCities(TripType cityType) {
        Firebase eventsRef = new Firebase(F.rootNode + F.NodeMaps.get(cityType));
        eventsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<City> cities = new ArrayList<City>();
                for(DataSnapshot city: dataSnapshot.getChildren())
                {
                    City c = city.getValue(City.class);
                    cities.add(c);
                }
                ListAdapter listAdp = new CityListAdapter(getActivity(), cities, R.layout.event_list_single_view);
                listView.setAdapter(listAdp);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    private void LoadEventsData() {
        // Fetch data from firebase and populate the listview
        Firebase eventsRef = new Firebase(F.rootNode + F.eventsRefNode);
        eventsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Trip> trips = new ArrayList<Trip>();
                for (DataSnapshot trip : dataSnapshot.getChildren()) {
                    Trip t = trip.getValue(Trip.class);
                    t.ID = trip.getKey();
                    trips.add(t);
                }
                ListAdapter listAdp = new CustomAdapter(getActivity(), trips, R.layout.event_list_single_view);
                listView.setAdapter(listAdp);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
