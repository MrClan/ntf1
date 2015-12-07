package com.apptivators.ntcore;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.apptivators.ntcore.Utils.U;
import com.astuetz.PagerSlidingTabStrip;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        U.Intialize(this);

        getSupportActionBar().hide();


        ViewPager viewPager = (ViewPager) findViewById(R.id.vpDashboard);
        viewPager.setAdapter(new DashboardPagerAdapter(getSupportFragmentManager()));


        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabsDashboard);
        tabsStrip.setShouldExpand(true);
        tabsStrip.setViewPager(viewPager);
        tabsStrip.setShouldExpand(false);
    }
}