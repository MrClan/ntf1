package com.apptivators.ntcore;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.apptivators.ntcore.Models.NepTripPackage;


public class packageDetailCalendar_Fragment extends Fragment
{
    public static final String ARG_PAGE = "ARG_Page";
    private int mPage;
    ListView listView;
    static NepTripPackage nepTripPackage;
    public static packageDetailCalendar_Fragment newInstance(int page, NepTripPackage pck) {
        Bundle args = new Bundle();
        nepTripPackage = pck;
        packageDetailCalendar_Fragment fragment = new packageDetailCalendar_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.package_detail_calendar_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.listCalendar);

        String[] events = new String[] {"Day 1","Day 2", "Day 3" , "Day 4"};


        ListAdapter listAdp = new TempCalendarAdapter(getActivity(), events,R.layout.calendar_list_single_view);
        listView.setAdapter(listAdp);

        return view;
    }
}
