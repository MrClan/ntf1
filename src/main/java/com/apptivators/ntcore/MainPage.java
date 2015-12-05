package com.apptivators.ntcore;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.apptivators.ntcore.Utils.F;
import com.apptivators.ntcore.Utils.U;
import com.firebase.client.Firebase;


public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        getSupportActionBar().hide();

        U.Intialize(this);

        ImageButton btnWallpaper = (ImageButton) findViewById(R.id.btnWallpaper);
    }

    public void onClick(View v)
    {
        // if user already setup never comeback to this view
        // if user not already setup, prompt the user to setup their basic profile
        if(U.CheckUserStatus()) {
            U.GoToHome();
            finish();
        }

        else {
            U.GoToProfileSetup();
            finish();
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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