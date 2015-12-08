package com.apptivators.ntcore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by suchan on 9/12/2015.
 */
public class TempCustomeAdapter extends ArrayAdapter<String>
{
    private int resourceId = 0;
    public TempCustomeAdapter(Context context, String[] foods , int id)
    {
        super(context,id,foods);
        resourceId = id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater eventListViewInflater = LayoutInflater.from(getContext());
        View customView = eventListViewInflater.inflate(resourceId,parent,false);

        String eventTitle = getItem(position);
        TextView eventTitleView = (TextView) customView.findViewById(R.id.lblEventTitle);

        eventTitleView.setText(eventTitle);

        return customView;
    }
}
