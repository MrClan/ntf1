package com.apptivators.ntcore;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.apptivators.ntcore.Models.NepTripPackage;
import com.apptivators.ntcore.Utils.U;


public class packageDetailDescription_Fragment extends Fragment {
    public static final String ARG_PAGE = "ARG_Page";
    private int mPage;
    static NepTripPackage nepTripPackage;
    Button btnBuy;

    public static packageDetailDescription_Fragment newInstance(int page, NepTripPackage pck) {
        Bundle args = new Bundle();
        nepTripPackage = pck;
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

        btnBuy = (Button) view.findViewById(R.id.btnBuy);

        TextView tvDescription = (TextView) view.findViewById(R.id.lblPackageDescription);

        CheckPurchaseStatus(nepTripPackage);


        String packageDetail = nepTripPackage.getDescription() +
                "\n\nAccomodation: " + nepTripPackage.getAccomodation() +
                "\n\nTransportation within city: " + nepTripPackage.getTransportationwithincity() +
                "\n\nBudget type: " + nepTripPackage.getBudgettype() +
                "\n\nCost: " + nepTripPackage.getCost() +
                "\n\nDuration: " + nepTripPackage.getDuration() +
                "\n\nTransportation mode: " + nepTripPackage.getTransportationmode() +
                "\n\nTrip route: " + nepTripPackage.getTriproute();
        tvDescription.setText(packageDetail);
        return view;
    }

    private void CheckPurchaseStatus(NepTripPackage nepTripPackage) {
        if (U.GetBuyStatus(nepTripPackage)) {
            btnBuy.setText("PURCHASED");
            btnBuy.setEnabled(false);
        }
        else
        {
            btnBuy.setText("BUY PACKAGE");
            btnBuy.setEnabled(true);
        }
    }


}
