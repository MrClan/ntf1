package com.apptivators.ntcore.Utils;

/**
 * Created by Pratik on 12/6/2015.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.apptivators.ntcore.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquareImageAdapter extends BaseAdapter {
    private Context mContext;

    public SquareImageAdapter(Context c) {
        mContext = c;
        //List<Integer> thumbIds = new ArrayList<>();
        /*for(Category cat : Category.GetAll())
            thumbIds.add(cat.imgResourceId);*/
        // mThumbIds = thumbIds.toArray(new Integer[thumbIds.size()]);
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
    public View getView(int position, View convertView, ViewGroup parent) {
        SquareImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new SquareImageView(mContext);
            //imageView.setLayoutParams(new GridView.LayoutParams(400, 400));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (SquareImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }


    // references to our images
    private Integer[] mThumbIds =
            {
                    R.drawable.img_menu_adventure,
                    R.drawable.img_menu_something1,
                    R.drawable.img_menu_exploring,
                    R.drawable.img_menu_hiking,
                    R.drawable.img_menu_mountaineering,
                    R.drawable.img_menu_roaming,
                    R.drawable.img_menu_something2,
                    R.drawable.img_menu_casual,
                    R.drawable.img_menu_romantic,
                    R.drawable.img_menu_transportation_plane,
                    R.drawable.img_menu_transportation_bike,
                    R.drawable.img_menu_transportation_bus,
                    R.drawable.img_menu_transportation_cycle,
                    R.drawable.img_menu_transportation_jeep,
                    R.drawable.img_menu_transportation_rickshaw,
                    R.drawable.img_menu_transportation_taxi,
                    R.drawable.img_menu_transportation_tempo,
                    R.drawable.img_menu_transportation_walking
            };
}