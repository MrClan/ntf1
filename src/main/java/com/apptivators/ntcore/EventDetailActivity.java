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

import com.apptivators.ntcore.Models.Event;
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

        /*getSupportActionBar().setTitle("Event Details");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
        setContentView(R.layout.event_detail_view);

        ButterKnife.bind(this);

        Bundle b = this.getIntent().getExtras();
        Event event = (Event)b.getSerializable("curItem");

        lblTitle.setText(event.getTitle());
        lblEventDetail.setText("From " + event.getStartdate() + " till " + event.getEnddate() + " at " + event.getCity());
        U.LoadImage(this, iv, event.getImgName());


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager(), event));


        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabsStrip.setShouldExpand(true);
        tabsStrip.setViewPager(viewPager);
        tabsStrip.setShouldExpand(false);

        final Toolbar advToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        advToolbar.setTitle("Event Detail");
        advToolbar.setTitleTextColor(R.color.colorPrimaryDark);
        advToolbar.inflateMenu(R.menu.advance_search);
    }
}
