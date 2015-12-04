package com.apptivators.ntcore;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends Fragment
{
    ImageButton iBtnRomantic,imgBtnFb,imgBtnGoogle,btnLogin;
    TextView txtTitle,txtEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //GET VIEW CACHED VARIABLES
        View view = inflater.inflate(R.layout.login_page, container, false);

        ImageButton imgBtnGoogle = (ImageButton) view.findViewById(R.id.imgBtnGoogle);
        ImageButton imgBtnFb = (ImageButton) view.findViewById(R.id.imgBtnFb);
        ImageButton btnLogin = (ImageButton) view.findViewById(R.id.btnLogin);
        TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        TextView txtEmail = (TextView) view.findViewById(R.id.txtEmail);

        //SET THE ACTIONBAR TITLE & ICON
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Login");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //CHANGE TITLE AND EMAIL FONT
        Typeface face2= Typeface.createFromAsset(getActivity().getAssets(), "fonts/Lato-Regular.ttf");
        txtTitle.setTypeface(face2);
        txtEmail.setTypeface(face2);


        //ON LOGIN BUTTON CLICKED
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Signing In Clicked", Toast.LENGTH_LONG).show();
            }
        });

        //ON FAGEBOOK BUTTON CLICKED
        imgBtnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getActivity(), "Facebook Login Clicked", Toast.LENGTH_LONG).show();
            }
        });

        //ON GOOGLE BUTTON CLICKED
        imgBtnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getActivity(), "Google Login Clicked", Toast.LENGTH_LONG).show();
            }
        });

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
