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
import android.widget.Toast;


public class EventsActivity  extends Fragment
{
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        String[] events;

        //GET VIEW CACHED VARIABLES
        View view = inflater.inflate(R.layout.event_list_main_view, container, false);
        listView = (ListView) view.findViewById(R.id.listViewFood);
        String mTitle = getArguments().getString("title");

        //SET THE ACTIONBAR TITLE & ICON
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(mTitle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //POPULATE THE LIST VIEW
        if(mTitle=="Featured Events")
            events = new String[] {"Featured Event I ","Featured Event II ","Featured Event III ","Featured Event IV ","Featured Event V ","Featured Event VI ","Featured Event VII ","Featured Event VIII ","Featured Event IX ","Featured Event X"};
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




        ListAdapter listAdp = new CustomAdapter(getActivity(), events,R.layout.event_list_single_view);
        listView.setAdapter(listAdp);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(getActivity(), food, Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getActivity(), EventDetailActivity.class);
                        startActivity(i);
                    }
                }
        );
        return view;
    }
}
