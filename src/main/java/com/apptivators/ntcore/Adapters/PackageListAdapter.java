package com.apptivators.ntcore.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.apptivators.ntcore.Models.City;
import com.apptivators.ntcore.Models.NepTripPackage;
import com.apptivators.ntcore.R;
import com.apptivators.ntcore.Utils.U;

import java.util.List;

/**
 * Created by Pratik on 12/8/2015.
 */
public class PackageListAdapter extends ArrayAdapter<NepTripPackage>{
    private int resourceId = 0;
    private List<NepTripPackage> items;
    public PackageListAdapter(Context context, List<NepTripPackage> packages , int id)
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

        NepTripPackage pck = getItem(position);
        TextView tvTitle = (TextView) view.findViewById(R.id.lblPackageTitle);
        TextView tvHost = (TextView) view.findViewById(R.id.lblPackageHost);
        TextView tvDuration = (TextView) view.findViewById(R.id.lblPackageDuration);

        tvTitle.setText(pck.getTitle());
        tvHost.setText(pck.Host);
        tvDuration.setText(pck.getDuration());


        return view;
    }

    public void SwapItems(List<NepTripPackage> packages)
    {
        this.items = packages;
        notifyDataSetChanged();
    }
}
