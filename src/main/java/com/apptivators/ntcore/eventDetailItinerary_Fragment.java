package com.apptivators.ntcore;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apptivators.ntcore.Models.DailyIteneraryModel;
import com.apptivators.ntcore.Models.Event;

/**
 * Created by Pratik on 12/8/2015.
 */
public class eventDetailItinerary_Fragment extends Fragment {

    public static final String ARG_PAGE = "ARG_Page";
    private int mPage;
    static Event event;

    public static eventDetailItinerary_Fragment newInstance(int page, Event ev) {
        Bundle args = new Bundle();
        eventDetailItinerary_Fragment.event = ev;
        eventDetailItinerary_Fragment fragment = new eventDetailItinerary_Fragment();
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
        View view = inflater.inflate(R.layout.event_detail_description_fragment, container, false);

        TextView tvTitle = (TextView) view.findViewById(R.id.eventTitle);
        tvTitle.setVisibility(View.INVISIBLE);
        TextView tvDesc = (TextView) view.findViewById(R.id.txtDescription);

        DailyIteneraryModel di = event.getDailyitinerary();

        String evDetail = "Day 1: " + di.getDay1() +
                (TextUtils.isEmpty(di.getDay2())?"":  "\n\nDay 2: " + event.getDailyitinerary().getDay2()) +
                (TextUtils.isEmpty(di.getDay3())?"":  "\n\nDay 3: " + event.getDailyitinerary().getDay3()) +
                (TextUtils.isEmpty(di.getDay4())?"":  "\n\nDay 4: " + event.getDailyitinerary().getDay4()) +
                (TextUtils.isEmpty(di.getDay5())?"":  "\n\nDay 5: " + event.getDailyitinerary().getDay5()) +
                (TextUtils.isEmpty(di.getDay6())?"":  "\n\nDay 6: " + event.getDailyitinerary().getDay6()) +
                (TextUtils.isEmpty(di.getDay7())?"":  "\n\nDay 7: " + event.getDailyitinerary().getDay7()) +
                (TextUtils.isEmpty(di.getDay8())?"":  "\n\nDay 8: " + event.getDailyitinerary().getDay8()) +
                (TextUtils.isEmpty(di.getDay9())?"":  "\n\nDay 9: " + event.getDailyitinerary().getDay9()) +
                (TextUtils.isEmpty(di.getDay10())?"": "\n\nDay 10: " + event.getDailyitinerary().getDay10()) +
                (TextUtils.isEmpty(di.getDay11())?"": "\n\nDay 11: " + event.getDailyitinerary().getDay11()) +
                (TextUtils.isEmpty(di.getDay12())?"": "\n\nDay 12: " + event.getDailyitinerary().getDay12()) +
                (TextUtils.isEmpty(di.getDay13())?"": "\n\nDay 13: " + event.getDailyitinerary().getDay13()) +
                (TextUtils.isEmpty(di.getDay14())?"": "\n\nDay 14: " + event.getDailyitinerary().getDay14()) +
                (TextUtils.isEmpty(di.getDay15())?"": "\n\nDay 15: " + event.getDailyitinerary().getDay15()) +
                (TextUtils.isEmpty(di.getDay16())?"": "\n\nDay 16: " + event.getDailyitinerary().getDay16()) +
                (TextUtils.isEmpty(di.getDay17())?"": "\n\nDay 17: " + event.getDailyitinerary().getDay17()) +
                (TextUtils.isEmpty(di.getDay18())?"": "\n\nDay 18: " + event.getDailyitinerary().getDay18()) +
                (TextUtils.isEmpty(di.getDay19())?"": "\n\nDay 19: " + event.getDailyitinerary().getDay19()) +
                (TextUtils.isEmpty(di.getDay20())?"": "\n\nDay 20: " + event.getDailyitinerary().getDay20()) +
                (TextUtils.isEmpty(di.getDay21())?"": "\n\nDay 21: " + event.getDailyitinerary().getDay21()) +
                (TextUtils.isEmpty(di.getDay22())?"": "\n\nDay 22: " + event.getDailyitinerary().getDay22()) +
                (TextUtils.isEmpty(di.getDay23())?"": "\n\nDay 23: " + event.getDailyitinerary().getDay23()) +
                (TextUtils.isEmpty(di.getDay24())?"": "\n\nDay 24: " + event.getDailyitinerary().getDay24()) +
                (TextUtils.isEmpty(di.getDay25())?"": "\n\nDay 25: " + event.getDailyitinerary().getDay25());


        tvDesc.setText(evDetail);

        return view;
    }
}
