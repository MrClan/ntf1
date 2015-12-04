package com.apptivators.ntcore;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.apptivators.ntcore.Models.Trip;
import com.apptivators.ntcore.Utils.U;
import com.astuetz.PagerSlidingTabStrip;

import butterknife.Bind;
import butterknife.ButterKnife;


public class EventDetailActivity extends AppCompatActivity
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

        getSupportActionBar().setTitle("Event Details");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.event_detail_view);

        ButterKnife.bind(this);

        Bundle b = this.getIntent().getExtras();
        Trip trip = (Trip)b.getSerializable("curTrip");

        lblTitle.setText(trip.getTitle());
        lblEventDetail.setText("From " + trip.getStartTime() + " till " + trip.getEndTime() + " at " + trip.getVenue());
        U.LoadImage(this, iv, trip.getImgName());


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager()));


        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabsStrip.setShouldExpand(true);
        tabsStrip.setViewPager(viewPager);
        tabsStrip.setShouldExpand(false);
    }
}
