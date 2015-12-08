package com.apptivators.ntcore;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.apptivators.ntcore.Models.Event;
import com.astuetz.PagerSlidingTabStrip;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
    final int PAGE_COUNT = 4;
    private int tabIcons[] = {R.drawable.img_btn_home,R.drawable.img_btn_accomodation,  R.drawable.img_btn_map, R.drawable.img_btn_calendar};
    Event event;
    public SampleFragmentPagerAdapter(FragmentManager fm, Event event) {
        super(fm);
        this.event = event;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position)
    {
        if(position==0)
            return eventDetailDescription_Fragment.newInstance(position + 1, event);
        else if(position==1)
            //return eventDetailGallery_Fragment.newInstance(position + 1);
            return eventDetailItinerary_Fragment.newInstance(position + 1, event);
        else if(position==2)
            return eventDetailMap_Fragment.newInstance(position + 1);
        else
            return eventDetailCalendar_Fragment.newInstance(position + 1);
    }

    @Override
    public int getPageIconResId(int position) {
        return tabIcons[position];
    }
}
