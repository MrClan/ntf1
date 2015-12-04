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
public class CustomAdapter extends ArrayAdapter<String>
{
    private int resourceId = 0;
    public CustomAdapter(Context context, String[] foods , int id)
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
        ImageView eventImage = (ImageView) customView.findViewById(R.id.imgEventPic);

        eventTitleView.setText(eventTitle);
        //eventImage.setImageResource(R.drawable.event_pic);

        return customView;
    }
}
