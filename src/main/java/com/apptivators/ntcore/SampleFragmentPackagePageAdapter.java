package com.apptivators.ntcore;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.apptivators.ntcore.Models.NepTripPackage;
import com.astuetz.PagerSlidingTabStrip;

public class SampleFragmentPackagePageAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
    final int PAGE_COUNT = 4;
    private int tabIcons[] = {R.drawable.img_btn_home, R.drawable.img_btn_accomodation, R.drawable.img_btn_map, R.drawable.img_btn_calendar, R.drawable.img_btn_contact};
    NepTripPackage nepTripPackage;


    public SampleFragmentPackagePageAdapter(FragmentManager fm, NepTripPackage pck) {
        super(fm);
        this.nepTripPackage = pck;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return packageDetailDescription_Fragment.newInstance(position + 1, nepTripPackage);
        else if (position == 1)
            return packageDetailAccomodation_Fragment.newInstance(position + 1, nepTripPackage);
        else if (position == 2)
            return packageDetailMap_Fragment.newInstance(position + 1, nepTripPackage);
        else if (position == 3)
            return packageDetailCalendar_Fragment.newInstance(position + 1, nepTripPackage);
        else
            return packageDetailDescription_Fragment.newInstance(position + 1, nepTripPackage);
    }

    @Override
    public int getPageIconResId(int position) {
        return tabIcons[position];
    }
}
