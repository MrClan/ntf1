package com.apptivators.ntcore;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by suchan on 11/29/2015.
 */
public class Preferences extends Fragment
{
    TextView txtPref01,txtPref02,txtPref03,txtPref04,txtPref05,txtPref06,txtPref07;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //GET VIEW CACHED VARIABLES
        View view = inflater.inflate(R.layout.preference_setting, container, false);
        TextView txtPref01 = (TextView) view.findViewById(R.id.txtPref01);
        TextView txtPref02 = (TextView) view.findViewById(R.id.txtPref02);
        TextView txtPref03 = (TextView) view.findViewById(R.id.txtPref03);
        TextView txtPref04 = (TextView) view.findViewById(R.id.txtPref04);
        TextView txtPref05 = (TextView) view.findViewById(R.id.txtPref05);
        TextView txtPref06 = (TextView) view.findViewById(R.id.txtPref06);
        TextView txtPref07 = (TextView) view.findViewById(R.id.txtPref07);


        //SET THE ACTIONBAR TITLE & ICON
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Setting");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //CHANGE THE FONT
        Typeface face2= Typeface.createFromAsset(getActivity().getAssets(), "fonts/Lato-Regular.ttf");
        txtPref01.setTypeface(face2);
        txtPref02.setTypeface(face2);
        txtPref03.setTypeface(face2);
        txtPref04.setTypeface(face2);
        txtPref05.setTypeface(face2);
        txtPref06.setTypeface(face2);
        txtPref07.setTypeface(face2);

        return view;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
