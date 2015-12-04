package com.apptivators.ntcore.Utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.apptivators.ntcore.HomePage;
import com.apptivators.ntcore.MainPage;
import com.apptivators.ntcore.Models.User;
import com.apptivators.ntcore.UsersetupActivity;
import com.bumptech.glide.Glide;
import com.firebase.client.Firebase;

/**
 * Created by Pratik on 12/4/2015.
 */
public class U {

    public static Context c;
    private final static String settingsFileName = "App_Settings";
    private final static String userNameKey = "userkey";

    public static boolean CheckUserStatus() {
        // check sharedPreferences for existing user details
        // if not found, prompt the user for profile setup
        String username = GetLocalUser();
            if (!username.isEmpty())
                return true;
            else
                return false;
    }

    public static String GetLocalUser() {
        SharedPreferences preferences = c.getSharedPreferences(settingsFileName, c.MODE_PRIVATE);
        return preferences.getString(userNameKey, "");
    }

    public static void GoToHome() {
        GoToActivity(HomePage.class);
    }

    public static void GoToProfileSetup()
    {
        GoToActivity(UsersetupActivity.class);
    }

    private static void GoToActivity(Class activityClass) {
        Intent i = new Intent(c, activityClass);
        c.startActivity(i);
    }

    public static void Intialize(Context ctx) {
        // INITIALIZE THE CONTEXT OBJECT FOR Utils class ::: VERY IMPORTANT
        U.c = ctx;
        Firebase.setAndroidContext(ctx);
        //F.AddTrips(); ONE TIME METHOD
    }

    public static void ShowToast(String msg)
    {
        Toast.makeText(c, msg, Toast.LENGTH_SHORT).show();
    }

    public static void ShowAlert(String msg)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(c);
        alert.setMessage(msg);
        alert.show();
    }

    public static void SetLocalUser(User user) {
        SharedPreferences preferences = c.getSharedPreferences(settingsFileName, c.MODE_PRIVATE);
        SharedPreferences.Editor userKeyEditor = preferences.edit();
        userKeyEditor.putString(userNameKey, user.getUsername());
        userKeyEditor.apply();
    }

    public static void LoadImage(Context ctx, ImageView iv, String imgUrl)
    {
        Glide.with(ctx)
                .load(imgUrl)
                .centerCrop()
                .into(iv);
    }


    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public static void ShowProgress(final boolean show, final View view) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = c.getResources().getInteger(android.R.integer.config_shortAnimTime);

            view.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    view.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            view.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    view.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            view.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
}
