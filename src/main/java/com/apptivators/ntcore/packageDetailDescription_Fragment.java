package com.apptivators.ntcore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class packageDetailDescription_Fragment extends Fragment
{
    public static final String ARG_PAGE = "ARG_Page";
    private int mPage;

    public static packageDetailDescription_Fragment newInstance(int page) {
        Bundle args = new Bundle();
        packageDetailDescription_Fragment fragment = new packageDetailDescription_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.package_detail_description_fragment, container, false);
        return view;
    }
}