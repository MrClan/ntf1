package com.apptivators.ntcore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.apptivators.ntcore.Models.Trip;

import java.util.List;

/**
 * Created on 12/2/2015
 * By : $(USER)<suchan211@gmail.com>
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private int contentViewType;

    public ImageAdapter(Context c , int type) {
        mContext = c;
        contentViewType = type;
        inflater = (LayoutInflater) mContext.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    private static LayoutInflater inflater = null;


    public class Holder
    {
        TextView tv;
        ImageView img;
    }


    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        /*ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            //imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setPadding(8, 8, 8, 8);
            ListAdapter listAdp = new CustomAdapter(getActivity(), trips,R.layout.event_list_single_view);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);*/


        Holder holder=new Holder();
        View rowView;

        if(contentViewType==0) {
            rowView = inflater.inflate(R.layout.event_list_single_view, null);
            holder.tv = (TextView) rowView.findViewById(R.id.lblEventTitle);
        }
        else if(contentViewType==1) {
            rowView = inflater.inflate(R.layout.event_grid_single_view, null);
            holder.tv = (TextView) rowView.findViewById(R.id.lblCity);
        }
        else {
            rowView = inflater.inflate(R.layout.event_list_single_view, null);
            holder.tv = (TextView) rowView.findViewById(R.id.lblEventTitle);
        }

        holder.img=(ImageView) rowView.findViewById(R.id.imgEventPic);

        holder.tv.setText(mThumbInfo[position]);
        holder.img.setImageResource(mThumbIds[position]);

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(mContext, "You Clicked " + mThumbInfo[position], Toast.LENGTH_LONG).show();
            }
        });

        return rowView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.city_butwal, R.drawable.city_kathmandu,
            R.drawable.city_chitwan, R.drawable.city_jumla,
            R.drawable.city_karnali, R.drawable.city_kavre,
            R.drawable.city_pokhara, R.drawable.city_janakpur,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };

    private String[] mThumbInfo = {
            "Butwal", "Kathmandu",
            "Chitwan", "Jumla",
            "Karnali", "Kavre",
            "Pokhara", "Janakpur",
            "sample_2", "sample_3",
            "sample_4", "sample_5",
            "sample_6", "sample_7",
            "sample_0", "sample_1",
            "sample_2", "sample_3",
            "sample_4", "sample_5",
            "sample_6", "sample_7"
    };
}