package com.apptivators.ntcore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.apptivators.ntcore.Models.Trip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suchan on 11/25/2015.
 */
public class FeaturedActivity extends ActionBarActivity
{
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.featured_list_main_view);
        getSupportActionBar().setTitle("Featured Activities");

        //toolbar = (Toolbar) findViewById(R.id.toolbar);

        //String[] events = {"Trisuli Rafting","Rafting mela","White water Rafting","Sunshine Rafting","Raft Nepal 2015","Canoning","Global Rafting","Rafting for a cause","Keep Rafting","Raft Today"};

        List<Trip> events = new ArrayList<>();

        ListAdapter listAdp = new CustomAdapter(this, events, R.layout.favorite_list_single_view);
        ListView listViewNew = (ListView) findViewById(R.id.listViewFood);
        listViewNew.setAdapter(listAdp);

        listViewNew.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        Intent i = new Intent(FeaturedActivity.this, EventDetailActivity.class);
                        startActivity(i);
                    }
                }
        );
    }
    public void onFeatureClicked(View v)
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
