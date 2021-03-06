package com.apptivators.ntcore;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.apptivators.ntcore.Adapters.PackageListAdapter;
import com.apptivators.ntcore.Models.NepTripPackage;
import com.apptivators.ntcore.Utils.F;
import com.apptivators.ntcore.Utils.U;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class PackageActivity extends Fragment {
    ListView listView;
    ProgressDialog progress;
    String dataType;
    View view;
    Spinner sCity;
    String[] cityCategory=null;
    String[] dateCategory= null;
    Toolbar toolbar=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //GET VIEW CACHED VARIABLES
        view = inflater.inflate(R.layout.package_list_main_view, container, false);
        listView = (ListView) view.findViewById(R.id.listPackageView);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        NepTripPackage curItem = (NepTripPackage)(parent.getItemAtPosition(position));
                        Intent i = new Intent(getActivity(), PackageDetailActivity.class);
                        Bundle b = new Bundle();
                        b.putSerializable("curItem", curItem);
                        i.putExtras(b);
                        startActivity(i);
                    }
                }
        );
        String mTitle = getArguments().getString("title");
        dataType = getArguments().getString("dataType");

        if(dataType== null)
            dataType="";

        progress = ProgressDialog.show(getActivity(), "Loading","please wait", true);

        //SETUP THE TOOLBAR
        setupToolbar();

        //SETUP THE FILTER TOOLBAR
        //setupFilterToolbar();

        LoadPackageList();
        return view;
    }

    static List<NepTripPackage> packages = new ArrayList<NepTripPackage>();

    private void LoadPackageList()
    {
        if(U.IsOnline()) {
            Firebase packagesRef = new Firebase(F.rootNode + F.packagesNode);
            packagesRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot pck : dataSnapshot.getChildren()) {
                        NepTripPackage p = pck.getValue(NepTripPackage.class);
                        p.Host = pck.getKey();
                        packages.add(p);
                    }

                    Activity act = getActivity();
                    if(act!= null) {
                        PackageListAdapter listAdp = new PackageListAdapter(act, packages, R.layout.package_list_single_view);
                        listView.setAdapter(listAdp);
                    }

                    progress.dismiss();
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
    }

    private void setupFilterToolbar() {
        cityCategory = getResources().getStringArray(R.array.category);
        dateCategory = getResources().getStringArray(R.array.date);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);


        SpinnerAdapter spinnerCityAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.category, R.layout.spinner_dropdown_item);
        //SpinnerAdapter spinnerDateAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.date, R.layout.spinner_dropdown_item);

        Spinner citySpinner = new Spinner(getActivity());
        citySpinner.setAdapter(spinnerCityAdapter);
        toolbar.addView(citySpinner, 0);

//        Spinner dateSpinner = new Spinner(getActivity());
//        dateSpinner.setAdapter(spinnerDateAdapter);
//        dateSpinner.setVisibility(View.INVISIBLE);
//        toolbar.addView(dateSpinner, 0);

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {

                    String selectedCity = cityCategory[position].toLowerCase();
                    if (packages.size() > 0) {
                        ArrayList<NepTripPackage> searchResults = new ArrayList<NepTripPackage>();
                        for (NepTripPackage p : packages) {
                            if (p.getCity().toLowerCase().equalsIgnoreCase(selectedCity))
                                searchResults.add(p);
                        }
                        PackageListAdapter listAdp = new PackageListAdapter(getActivity(), searchResults, R.layout.package_list_single_view);
                        listView.setAdapter(listAdp);
                    }
                } else {
                    PackageListAdapter listAdp = new PackageListAdapter(getActivity(), packages, R.layout.package_list_single_view);
                    listView.setAdapter(listAdp);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setupToolbar()
    {
        final Toolbar advToolbar = (Toolbar) view.findViewById(R.id.my_awesome_toolbar);
        advToolbar.setNavigationIcon(R.drawable.nav_drawer);
        advToolbar.setTitle("Packages");
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
    }



}
