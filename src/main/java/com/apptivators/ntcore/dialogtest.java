package com.apptivators.ntcore;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.apptivators.ntcore.Models.Trip;


public class dialogtest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogtest);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Trip t = new Trip("Tilicho Trip", "New Travels", "Lazimpat", "Dhulikhel", "Nagarkot", 15000, "9th Dec", "9th Dec", "http://res.cloudinary.com/pratik/image/upload/v1449251051/4_n5ekjl.jpg", "Any", "Mountaineering", "Explore the uncharted terrains of Nepal. Places never been walked before. Experience most pristine form of nature.");

        setTitle(t.getTitle());


    }

}
