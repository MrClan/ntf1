package com.apptivators.ntcore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.apptivators.ntcore.Adapters.CityListAdapter;
import com.apptivators.ntcore.Adapters.EventListAdapter;
import com.apptivators.ntcore.Models.City;
import com.apptivators.ntcore.Models.Event;
import com.apptivators.ntcore.Models.Trip;
import com.apptivators.ntcore.Models.TripType;
import com.apptivators.ntcore.Utils.F;
import com.apptivators.ntcore.Utils.U;
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
        U.c = this.getActivity();

        if(dataType== null)
            dataType="";

        //SET THE ACTIONBAR TITLE & ICON
        //((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(mTitle);
        //((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //TODO: TAKES ABOUT 3-4 SECONDS, SO A PROGRESSBAR OR PROGRESSDIALOG WOULD BE NICE HERE
        LoadData();

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Event curItem = (Event) (parent.getItemAtPosition(position));
                        Intent i = new Intent(getActivity(), EventDetailActivity.class);
                        Bundle b = new Bundle();
                        b.putSerializable("curItem", curItem);
                        i.putExtras(b);
                        startActivity(i);
                    }
                }
        );

        //SETUP THE TOOLBAR
        final Toolbar advToolbar = (Toolbar) view.findViewById(R.id.my_awesome_toolbar);
        advToolbar.setNavigationIcon(R.drawable.nav_drawer);
        advToolbar.setTitle("Events");
        advToolbar.setTitleTextColor(R.color.colorPrimaryDark);
        advToolbar.inflateMenu(R.menu.advance_search);

        advToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                                                        if (drawer.isDrawerOpen(GravityCompat.START)) {
                                                            drawer.closeDrawer(GravityCompat.START);
                                                        } else {
                                                            drawer.openDrawer(GravityCompat.START);
                                                        }
                                                    }
                                                }
        );
        return view;
    }


    private void LoadData() {

        if(U.IsOnline()) {
            // Read from extras, and load data accordingly
            switch (dataType) {
                case "RomanticEvents":
                    LoadCities(TripType.ROMANTIC);
                    break;
                case "SocialEvents":
                case "Events":
                default:
                    LoadEventsData();
                    break;
            }
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
                List<Event> events = new ArrayList<Event>();
                for (DataSnapshot trip : dataSnapshot.getChildren()) {
                    Event e = trip.getValue(Event.class);
                    e.Host = trip.getKey();
                    events.add(e);
                }
                ListAdapter listAdp = new EventListAdapter(getActivity(), events, R.layout.event_list_single_view);
                listView.setAdapter(listAdp);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
