package com.apptivators.ntcore;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.apptivators.ntcore.Models.NepTripPackage;
import com.apptivators.ntcore.Utils.U;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created on 12/7/2015
 * by MrClan<justmepratik@gmail.com>
 */

public class CityListActivity extends AppCompatActivity
{

    private ListView listCityView;
    private ArrayAdapter<String> listAdapter;
    SearchView mSearchView;
    String mSearchString;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_list_main_view);

        listCityView = (ListView) findViewById(R.id.lvCity);

        //CREATE AND POPULATE A LIST OF CITIES
        String[] cities = {"Kathmandu","Bhaktapur","Lalitpur","Janakpur","Mustang","Manang","Gorkha","Pokhara","Dharan","Bhutwal","Bhaktapur","Lalitpur","Janakpur","Mustang","Manang","Gorkha","Pokhara","Dharan","Bhutwal"};

        ArrayList<String> cityList = new ArrayList<String>();
        cityList.addAll(Arrays.asList(cities));

        //CREATE ARRAY ADAPTER USING THE CITY ARRAY
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, cityList);
        listCityView.setAdapter(listAdapter);
        listCityView.setTextFilterEnabled(true);

        //SETUP THE TOOLBAR
        setupToolbar();

        //ON CITY LIST CLICKED
        listCityView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(CityListActivity.this, ListingPage.class);
                        i.putExtra("viewType", "Packages");
                        i.putExtra("dataType", "SocialEvents");
                        startActivity(i);
                    }
                }
        );
    }

    public boolean onSupportNavigateUp()
    {
        onBackPressed();
        return true;
    }

    private void setupToolbar()
    {
        final Toolbar advToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        advToolbar.setTitle("Package Cities");
        advToolbar.setTitleTextColor(R.color.colorPrimaryDark);

        setSupportActionBar(advToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.advance_search, menu);

        MenuItem searchItem = menu.findItem(R.id.action_searchAdv);

        SearchManager searchManager = (SearchManager) CityListActivity.this.getSystemService(Context.SEARCH_SERVICE);
        mSearchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_searchAdv));

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(CityListActivity.this.getComponentName()));
        }

        SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener()
        {
            public boolean onQueryTextChange(String newText)
            {
                mSearchString = newText;
                if (TextUtils.isEmpty(mSearchString)) {
                    listCityView.clearTextFilter();
                } else {
                    listCityView.setFilterText(mSearchString.toString());
                }
                return true;
            }

            public boolean onQueryTextSubmit(String query)
            {
                mSearchString = query;
                return true;
            }
        };
        mSearchView.setOnQueryTextListener(queryTextListener);

        return super.onCreateOptionsMenu(menu);
    }
}
