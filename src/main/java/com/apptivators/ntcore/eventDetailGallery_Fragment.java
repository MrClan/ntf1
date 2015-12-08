package com.apptivators.ntcore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created on 12/1/2015
 * By : $(USER)<suchan211@gmail.com>
 */
public class eventDetailGallery_Fragment extends Fragment
{
    GridView gridview;
    public static final String ARG_PAGE = "ARG_Page";
    private int mPage;
    private Integer[] mThumbIds = {
            R.drawable.img_featured,
            R.drawable.img_adventure,
            R.drawable.img_casual,
            R.drawable.img_romantic,
            R.drawable.img_hiking,
            R.drawable.img_mountaineering,
            R.drawable.img_exploring,
            R.drawable.img_social,
            R.drawable.img_festival
    };

    private String[] mThumbInfo = {
            "Featured",
            "Adventure",
            "Casual",
            "Romantic",
            "Hiking",
            "Mountaineering",
            "Exploring",
            "Social",
            "Festival",
    };

    public static eventDetailGallery_Fragment newInstance(int page) {
        Bundle args = new Bundle();
        eventDetailGallery_Fragment fragment = new eventDetailGallery_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.event_detail_gallery_fragment,container,false);
        gridview = (GridView)v.findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(v.getContext(),0,mThumbIds,mThumbInfo));
        return v;
    }
}
