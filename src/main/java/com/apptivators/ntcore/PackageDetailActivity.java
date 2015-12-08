package com.apptivators.ntcore;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.apptivators.ntcore.Models.Event;
import com.apptivators.ntcore.Models.NepTripPackage;
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

    NepTripPackage pck = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        U.c = this;

        //getSupportActionBar().setTitle("Event Details");
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("Package Detail");
        setContentView(R.layout.package_detail_view);
        setupToolbar();


        ButterKnife.bind(this);
        Bundle b = this.getIntent().getExtras();
        pck = (NepTripPackage)b.getSerializable("curItem");
        lblTitle.setText(pck.getTitle());
        lblEventDetail.setText("Duration: " + pck.getDuration());
        U.LoadImage(this, iv, pck.getImgName());


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPackagePageAdapter(getSupportFragmentManager(), pck));


        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabsStrip.setShouldExpand(true);
        tabsStrip.setViewPager(viewPager);
        tabsStrip.setShouldExpand(false);
    }

    public void BuyPackage(final View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Buy this package ?");
        alert.setCancelable(true);
        alert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                U.SetBuyStatus(pck);
                ((Button)view).setText("PURCHASED");
                view.setEnabled(false);
                U.ShowToast("Package successfully purchased.");
            }
        });
        alert.setNegativeButton("Not Now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }


    private void setupToolbar()
    {
        final Toolbar advToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        advToolbar.setTitle("Package Details");
        advToolbar.setTitleTextColor(R.color.colorPrimaryDark);
        advToolbar.inflateMenu(R.menu.advance_search);
    }
}
