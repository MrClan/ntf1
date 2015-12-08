package com.apptivators.ntcore;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.apptivators.ntcore.Models.Trip;
import com.apptivators.ntcore.Utils.F;
import com.apptivators.ntcore.Utils.U;
import com.astuetz.PagerSlidingTabStrip;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //GET VIEW CACHED VARIABLES
        final View view = inflater.inflate(R.layout.activity_dashboard, container, false);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.vpDashboard);
        viewPager.setAdapter(new DashboardPagerAdapter(getActivity().getSupportFragmentManager()));


        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tabsDashboard);
        tabsStrip.setTextColorResource(R.color.white);
        tabsStrip.setTextSize(35);
        tabsStrip.setShouldExpand(true);
        tabsStrip.setViewPager(viewPager);
        tabsStrip.setShouldExpand(false);

        //SETUP THE TOOLBAR
        final Toolbar advToolbar = (Toolbar) view.findViewById(R.id.my_awesome_toolbar);
        advToolbar.setNavigationIcon(R.drawable.nav_drawer);
        advToolbar.setTitle("Dashboard");
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
}