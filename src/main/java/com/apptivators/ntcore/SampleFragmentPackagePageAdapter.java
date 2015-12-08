package com.apptivators.ntcore;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.astuetz.PagerSlidingTabStrip;

public class SampleFragmentPackagePageAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
    final int PAGE_COUNT = 4;
    private int tabIcons[] = {R.drawable.img_btn_home, R.drawable.img_btn_gallery, R.drawable.img_btn_map, R.drawable.img_btn_calendar, R.drawable.img_btn_contact};

    public SampleFragmentPackagePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position)
    {
        if(position==0)
            return eventDetailDescription_Fragment.newInstance(position + 1);
        else if(position==1)
            return eventDetailGallery_Fragment.newInstance(position + 1);
        else if(position==2)
            return eventDetailMap_Fragment.newInstance(position + 1);
        else if(position==3)
            return eventDetailCalendar_Fragment.newInstance(position + 1);
        else
            return eventDetailGallery_Fragment.newInstance(position + 1);
    }

    @Override
    public int getPageIconResId(int position) {
        return tabIcons[position];
    }
}
