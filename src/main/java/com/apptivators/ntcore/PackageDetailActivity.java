package com.apptivators.ntcore;

import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.apptivators.ntcore.Models.Trip;
import com.apptivators.ntcore.Utils.U;
import com.astuetz.PagerSlidingTabStrip;

import butterknife.Bind;
import butterknife.ButterKnife;


public class PackageDetailActivity extends AppCompatActivity
{


    @Bind(R.id.iViewEventCoverPic)
    ImageView iv;
    @Bind(R.id.lblEventTitle)
    TextView lblTitle;
    @Bind(R.id.lblEventDetail)
    TextView lblEventDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //getSupportActionBar().setTitle("Event Details");
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("Package Detail");
        setContentView(R.layout.package_detail_view);
        setupToolbar();


/*        ButterKnife.bind(this);

        Bundle b = this.getIntent().getExtras();
        Trip trip = (Trip)b.getSerializable("curTrip");

        lblTitle.setText(trip.getTitle());
        lblEventDetail.setText("From " + trip.getStartTime() + " till " + trip.getEndTime() + " at " + trip.getVenue());
        U.LoadImage(this, iv, trip.getImgName());*/


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager()));


        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabsStrip.setShouldExpand(true);
        tabsStrip.setViewPager(viewPager);
        tabsStrip.setShouldExpand(false);
    }

    private void setupToolbar()
    {
        final Toolbar advToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        advToolbar.setTitle("Package Details");
        advToolbar.setTitleTextColor(R.color.colorPrimaryDark);
        advToolbar.inflateMenu(R.menu.advance_search);
    }
}
