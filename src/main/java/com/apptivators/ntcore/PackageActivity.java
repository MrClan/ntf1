package com.apptivators.ntcore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
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


public class PackageActivity extends Fragment {
    ListView listView;
    ProgressBar progressBar;
    String dataType;
    View view;
    Spinner sCity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //GET VIEW CACHED VARIABLES
        view = inflater.inflate(R.layout.package_list_main_view, container, false);
        listView = (ListView) view.findViewById(R.id.listPackageView);
        String mTitle = getArguments().getString("title");
        dataType = getArguments().getString("dataType");

        if(dataType== null)
            dataType="";

        //SETUP THE TOOLBAR
        setupToolbar();

        //LOAD TEMP DATA
        LoadListData();
        return view;
    }

    private void setupToolbar()
    {
        final Toolbar advToolbar = (Toolbar) view.findViewById(R.id.my_awesome_toolbar);
        advToolbar.setNavigationIcon(R.drawable.nav_drawer);
        advToolbar.setTitle("Events");
        advToolbar.setTitleTextColor(R.color.colorPrimaryDark);
        advToolbar.inflateMenu(R.menu.advance_search);

        advToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        Toast.makeText(getActivity(), "Nav drawer clicked", Toast.LENGTH_SHORT).show();
                                                        DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                                                        if (drawer.isDrawerOpen(GravityCompat.START)) {
                                                            drawer.closeDrawer(GravityCompat.START);
                                                        } else {
                                                            drawer.openDrawer(GravityCompat.START);
                                                        }
                                                    }
                                                }
        );
    }

    private void LoadListData()
    {

        String[] events = new String[] {"Featured Event I ","Featured Event II ","Featured Event III ","Featured Event IV ","Featured Event V ","Featured Event VI ","Featured Event VII ","Featured Event VIII ","Featured Event IX ","Featured Event X"};

        ListAdapter listAdp = new TempCustomeAdapter(getActivity(), events,R.layout.package_list_single_view);
        listView.setAdapter(listAdp);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(getActivity(), food, Toast.LENGTH_LONG).show();
                        //Intent i = new Intent(getActivity(), EventDetailActivity.class);
                        //startActivity(i);
                    }
                }
        );
    }

}
