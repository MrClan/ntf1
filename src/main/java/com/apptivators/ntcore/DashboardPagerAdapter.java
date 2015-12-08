package com.apptivators.ntcore;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.apptivators.ntcore.Utils.U;
import com.astuetz.PagerSlidingTabStrip;

import layout.FragAccomodation;
import layout.FragDestination;
import layout.FragEvent;
import layout.FragFacility;
import layout.FragPackage;
import layout.FragTransportation;

public class DashboardPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 5;
    private int tabIcons[] = {R.drawable.img_btn_home, R.drawable.img_btn_gallery, R.drawable.img_btn_map, R.drawable.img_btn_calendar, R.drawable.img_btn_contact, R.drawable.img_btn_home, R.drawable.img_btn_gallery};

    private String tabTitles[] = { "Packages", "Events","Transportation", "Accomodation",  "Facilities"};

    public DashboardPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return FragPackage.newInstance(); // pass the class of activity where we are supposed to navigate to on click of gridView item
        else if (position == 1)
            return FragEvent.newInstance();
        else if (position == 2) {
            U.ShowToast("Shows dummy contents right now");
            return FragTransportation.newInstance(null);
        } else if (position == 3) {
            U.ShowToast("Shows dummy contents right now");
            return FragAccomodation.newInstance(null);
        }
        if (position == 4) {
            U.ShowToast("Shows dummy contents right now");
            return FragFacility.newInstance(null);
        } else {
            U.ShowToast("Shows dummy contents right now");
            return FragEvent.newInstance();
        }
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

 /*   @Override
    public int getPageIconResId(int position) {
        return tabIcons[position];
    }*/
}
