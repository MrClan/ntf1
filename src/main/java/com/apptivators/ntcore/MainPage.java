package com.apptivators.ntcore;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.apptivators.ntcore.Utils.U;


public class MainPage extends AppCompatActivity {

    // Splash screen timer
    private static int pauseDuration = 2400;
    private ImageView imgIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        imgIcon = (ImageView) findViewById(R.id.imgIcon);
        //getSupportActionBar().hide();

        alphaAnimation();

        U.Intialize(this);
        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        onClick(null);
                    }
                }
                , pauseDuration);

    }

    private void alphaAnimation()
    {
        Animator anim = AnimatorInflater.loadAnimator(this, R.animator.alpha);
        anim.setTarget(imgIcon);
        anim.start();
    }

    public void onClick(View v)
    {
        // if user already setup never comeback to this view
        // if user not already setup, prompt the user to setup their basic profile
        if(U.CheckUserStatus()) {
            U.GoToHome();
        }
        else {
            U.GoToProfileSetup();
        }
        finish();
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
