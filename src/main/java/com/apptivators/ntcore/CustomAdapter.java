package com.apptivators.ntcore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.apptivators.ntcore.Models.Trip;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by suchan on 9/12/2015.
 */
public class CustomAdapter extends ArrayAdapter<Trip>
{
    private int resourceId = 0;
    public CustomAdapter(Context context, List<Trip> foods , int id)
    {
        super(context,id,foods);
        resourceId = id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater eventListViewInflater = LayoutInflater.from(getContext());
        View customView = eventListViewInflater.inflate(resourceId,parent,false);

        Trip event = getItem(position);
        TextView eventTitleView = (TextView) customView.findViewById(R.id.lblEventTitle);
        ImageView eventImage = (ImageView) customView.findViewById(R.id.imgEventPic);

        Glide.with(this.getContext())
                .load(event.getImgName())
                .into(eventImage);

        eventTitleView.setText(event.getTitle());
        //eventImage.setImageResource(R.drawable.event_pic);

        return customView;
    }
}
