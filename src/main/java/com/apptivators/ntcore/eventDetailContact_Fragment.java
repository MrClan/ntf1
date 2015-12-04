package com.apptivators.ntcore;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

/**
 * Created on 12/1/2015
 * By : $(USER)<suchan211@gmail.com>
 */
public class eventDetailContact_Fragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.event_detail_contact_fragment,container,false);
        return v;
    }
}
