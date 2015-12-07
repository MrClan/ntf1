package com.apptivators.ntcore.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.apptivators.ntcore.Models.City;
import com.apptivators.ntcore.Models.Trip;
import com.apptivators.ntcore.R;
import com.apptivators.ntcore.Utils.U;

import java.util.List;

/**
 * Created on 12/7/2015
 * by MrClan<justmepratik@gmail.com>
 */
public class CityListAdapter extends ArrayAdapter<City>
{
    private int resourceId = 0;
    public CityListAdapter(Context context, List<City> cities , int id)
    {
        super(context,id,cities);
        resourceId = id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(resourceId, parent, false);

        City city = getItem(position);
        TextView tvTitle = (TextView) view.findViewById(R.id.lblEventTitle);
        ImageView iv = (ImageView) view.findViewById(R.id.imgEventPic);

        String updateImgUrlToResizeImg = city.getImgName().replaceFirst("upload/","upload/w_450/");
        // replace upload/ with upload/w_450/

        U.LoadImage(this.getContext(), iv, updateImgUrlToResizeImg);

        tvTitle.setText(city.getName());
        //eventImage.setImageResource(R.drawable.event_pic);

        return view;
    }
}