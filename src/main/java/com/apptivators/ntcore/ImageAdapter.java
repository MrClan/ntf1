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
    private Integer[] mThumbIds;
    private String[] mThumbInfo;

    public ImageAdapter(Context c , int type,Integer[] mThumbIds,String[] mThumbInfo ) {
        mContext = c;
        contentViewType = type;
        this.mThumbIds =mThumbIds;
        this.mThumbInfo = mThumbInfo;
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

//        rowView.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Toast.makeText(mContext, "You Clicked " + mThumbInfo[position], Toast.LENGTH_LONG).show();
//            }
//        });

        return rowView;
    }

}