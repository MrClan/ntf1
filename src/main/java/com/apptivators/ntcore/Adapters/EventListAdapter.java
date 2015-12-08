package com.apptivators.ntcore.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.apptivators.ntcore.Models.Event;
import com.apptivators.ntcore.Models.NepTripPackage;
import com.apptivators.ntcore.Models.Trip;
import com.apptivators.ntcore.R;
import com.apptivators.ntcore.Utils.U;

import java.util.List;

/**
 * Created by Pratik on 12/8/2015.
 */

public class EventListAdapter extends ArrayAdapter<Event> {
    private int resourceId = 0;
    private List<Event> items;
    public EventListAdapter(Context context, List<Event> packages , int id)
    {
        super(context,id,packages);
        items = packages;
        resourceId = id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(resourceId, parent, false);

        Event event = getItem(position);
        TextView tvTitle = (TextView) view.findViewById(R.id.lblEventTitle);
        TextView tvHost = (TextView) view.findViewById(R.id.lblEventHost);
        TextView tvCost = (TextView) view.findViewById(R.id.lblEventCost);
        TextView tvVenue= (TextView) view.findViewById(R.id.lblEventVenueNTime);

        ImageView ivPic = (ImageView) view.findViewById(R.id.imgEventPic);

        tvTitle.setText(event.getTitle());
        tvCost.setText(event.getCost());
        tvHost.setText(event.Host);
        tvVenue.setText(event.getCity());

        U.LoadImage(view.getContext(), ivPic, event.getImgName());


        return view;
    }

    public void SwapItems(List<Event> packages)
    {
        this.items = packages;
        notifyDataSetChanged();
    }
}
