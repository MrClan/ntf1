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
    private Integer[] mThumbIds;

    public enum ItemType
    {
        TRANSPORTATION, ACCOMODATION, DESTINATION
    }

    public SquareImageAdapter(Context c, ItemType itemType ) {
        mContext = c;
        switch(itemType)
        {
            case ACCOMODATION:
                mThumbIds = mThumbIdsAccomodation;
                break;
            case DESTINATION:
                mThumbIds = mThumbIdsDestinations;
                break;
            case TRANSPORTATION:
                mThumbIds = mThumbIdsTransportation;
                break;
            default:
                mThumbIds = mThumbIdsDestinations;
        }
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
    private Integer[] mThumbIdsDestinations =
            {
                    R.drawable.img_menu_adventure,
                    R.drawable.img_menu_something1,
                    R.drawable.img_menu_exploring,
                    R.drawable.img_menu_hiking,
                    R.drawable.img_menu_mountaineering,
                    R.drawable.img_menu_roaming,
                    R.drawable.img_menu_something2,
                    R.drawable.img_menu_casual,
                    R.drawable.img_menu_romantic
            };

    private Integer[] mThumbIdsTransportation =
            {
                    R.drawable.flight,
                    R.drawable.micro_bus_4,
                    R.drawable.taxi1,
                    R.drawable.sajha_yatayat,
                    R.drawable.img_menu_transportation_bus,
                    R.drawable.img_menu_transportation_taxi
            };

    private Integer[] mThumbIdsAccomodation =
            {

                    R.drawable.img_menu_acomodation_fivestarhotel,
                    R.drawable.img_menu_acomodation_premiumhotel,
                    R.drawable.img_menu_acomodation_budgethotel,
                    R.drawable.img_menu_acomodation_homestay,
                    R.drawable.img_menu_acomodation_villa,
                    R.drawable.img_menu_acomodation_motel
            };
}