package com.apptivators.ntcore;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.apptivators.ntcore.Utils.U;

/**
 * Created on 12/7/2015
 * By : $(USER)<suchan211@gmail.com>
 */
public class EventListingPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    TextView txtNavHeaderWelcome;
    MenuItem nav_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_listing_page);
        //getSupportActionBar().hide();
        U.Intialize(this);
        U.c = this;

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        String username = U.GetLocalUser();
        txtNavHeaderWelcome = (TextView) findViewById(R.id.txtNavHeaderWelcome);
        txtNavHeaderWelcome.setText(txtNavHeaderWelcome.getText() + " @ " + username);


        //POPULATE THE FIRST PAGE AS FEATURED PAGE
        Fragment fragment = new EventsActivity();
        Bundle args = new Bundle();
        args.putString("dataType", "Events");
        fragment.setArguments(args);

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
    public boolean onNavigationItemSelected(MenuItem item) {
        boolean proceed = true;
        int id = item.getItemId();
        Fragment fragment = null;
        String title = null;
        if (id == R.id.nav_menu_review) {
            fragment = new EventsActivity();
            title = "Featured Events";
        } else if (id == R.id.nav_menu_review) {
            fragment = new EventsActivity();
            title = "Adventure Events";
        } else if (id == R.id.nav_menu_review) {
            fragment = new EventsActivity();
            title = "Casual Events";
        } else if (id == R.id.nav_menu_review) {
            fragment = new EventsActivity();
            title = "Exploring Events";
        } else if (id == R.id.nav_menu_review) {
            fragment = new EventsActivity();
            title = "Hiking Events";
        } else if (id == R.id.nav_menu_review) {
            fragment = new EventsActivity();
            Bundle args = new Bundle();
            args.putString("title", "Mountaineering Events");
        } else if (id == R.id.nav_menu_review) {
            fragment = new EventsActivity();
            title = "Romantic Events";
        } else if (id == R.id.nav_setting) {
            fragment = new Preferences();
        }
        else if(id== R.id.nav_menu_dashboard)
        {
            /*Intent i = new Intent(getBaseContext(), DashboardTabs.class);
            startActivity(i);*/
            proceed = false;
        }else if (id == R.id.nav_login) {
            // Show an alert before logging out
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Are you sure you want to logout of " + U.GetLocalUser() + "?");
            alert.setCancelable(true);
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Clear local user value, and redirect to setup page
                    U.ClearLocalUser();
                    Intent i = new Intent(getBaseContext(), UsersetupActivity.class);
                    startActivity(i);
                    finish();
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.show();
            proceed = false;
        }

        if (proceed) {
            Bundle args = new Bundle();
            fragment.setArguments(args);
            args.putString("title", title);

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
            U.ShowToast(title);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
