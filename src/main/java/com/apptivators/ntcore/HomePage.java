package com.apptivators.ntcore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.NavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created on 12/4/2015
 * By : $(USER)<suchan211@gmail.com>
 */
public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //POPULATE THE FIRST PAGE AS FEATURED PAGE
        Fragment fragment = new EventsActivity();
        Bundle args = new Bundle();
        args.putString("title", "Featured Events");
        fragment.setArguments(args);

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //getMenuInflater().inflate(R.menu.main,menu);
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.eventFeatured)
        {
            // Create a new fragment and specify the planet to show based on position
            Fragment fragment = new EventsActivity();
            Bundle args = new Bundle();
            args.putString("title", "Featured Events");
            fragment.setArguments(args);

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();

            // Highlight the selected item, update the title, and close the drawer
            Toast.makeText(HomePage.this, "Fragment Events Selected", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.eventAdventure)
        {
            // Create a new fragment and specify the planet to show based on position
            Fragment fragment = new EventsActivity();
            Bundle args = new Bundle();
            args.putString("title", "Adventure Events");
            fragment.setArguments(args);

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();

            // Highlight the selected item, update the title, and close the drawer
            Toast.makeText(HomePage.this, "Adventure Events Selected", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.eventCausal)
        {
            // Create a new fragment and specify the planet to show based on position
            Fragment fragment = new EventsActivity();
            Bundle args = new Bundle();
            args.putString("title", "Casual Events");
            fragment.setArguments(args);

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
            Toast.makeText(HomePage.this, "Featured Events Selected", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.eventExploring)
        {
            // Create a new fragment and specify the planet to show based on position
            Fragment fragment = new EventsActivity();
            Bundle args = new Bundle();
            args.putString("title", "Exploring Events");
            fragment.setArguments(args);

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
            Toast.makeText(HomePage.this, "Exploring Events Selected", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.eventHiking)
        {
            // Create a new fragment and specify the planet to show based on position
            Fragment fragment = new EventsActivity();
            Bundle args = new Bundle();
            args.putString("title", "Hiking Events");
            fragment.setArguments(args);

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
            Toast.makeText(HomePage.this, "Hiking Events Selected", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.eventMountaineering)
        {
            // Create a new fragment and specify the planet to show based on position
            Fragment fragment = new EventsActivity();
            Bundle args = new Bundle();
            args.putString("title", "Mountaineering Events");
            fragment.setArguments(args);

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
            Toast.makeText(HomePage.this, "Mountaineering Events Selected", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.eventRomantic)
        {
            // Create a new fragment and specify the planet to show based on position
            Fragment fragment = new EventsActivity();
            Bundle args = new Bundle();
            args.putString("title", "Romantic Events");
            fragment.setArguments(args);

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
            Toast.makeText(HomePage.this, "Romantic Events Selected", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_setting)
        {
            // Create a new fragment and specify the planet to show based on position
            Fragment fragment = new Preferences();
            Bundle args = new Bundle();
            fragment.setArguments(args);

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
            Toast.makeText(HomePage.this, "Setting Selected", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_login)
        {
            // Create a new fragment and specify the planet to show based on position
            Fragment fragment = new LoginPage();
            Bundle args = new Bundle();
            fragment.setArguments(args);

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
            Toast.makeText(HomePage.this, "Login Selected", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
