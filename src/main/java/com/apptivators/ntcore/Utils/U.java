package com.apptivators.ntcore.Utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.apptivators.ntcore.HomePage;
import com.apptivators.ntcore.MainPage;
import com.apptivators.ntcore.Models.NepTripPackage;
import com.apptivators.ntcore.Models.TripType;
import com.apptivators.ntcore.Models.User;
import com.apptivators.ntcore.UsersetupActivity;
import com.bumptech.glide.Glide;
import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pratik on 12/4/2015.
 */
public class U {

    public static Context c;
    private final static String settingsFileName = "App_Settings";
    private final static String userNameKey = "userkey";
    private final static String pckBuyDetailsKey = "pckBuyDetailsKey";


    public final static Map<TripType, String> TRIP_TYPE_STRING_MAP = new HashMap<TripType, String>() {
        {
            put(TripType.ADVENTURE, "Adventure");
            put(TripType.ROMANTIC, "Roamntic");
            put(TripType.CASUAL, "Casual");
            put(TripType.EXPLORING, "Exploring");
            put(TripType.FEATURED, "Featured");
            put(TripType.MOUNTAINEERING, "Mountaineering");
            put(TripType.SOCIAL, "Social");
            put(TripType.HIKING, "Hiking");
            put(TripType.FESTIVAL, "Festival");
        }
    };

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

    public static boolean GetBuyStatus(NepTripPackage nepTripPackage) {
        boolean buyStatus = false;
        if(nepTripPackage != null) {
            String packageTitle = nepTripPackage.getTitle();
            String buyDetailsKey = GetBuyString();
            if (!TextUtils.isEmpty(buyDetailsKey)) {
                for (String s : TextUtils.split(buyDetailsKey, ";;;")) {
                    if (s.equalsIgnoreCase(packageTitle)) {
                        buyStatus = true;
                        break;
                    }
                }
            }
        }
        return buyStatus;
    }

    private static String GetBuyString()
    {
        SharedPreferences preferences = c.getSharedPreferences(settingsFileName, c.MODE_PRIVATE);
        return  preferences.getString(pckBuyDetailsKey, "");
    }


    public static void SetLocalUser(User user) {
        SharedPreferences preferences = c.getSharedPreferences(settingsFileName, c.MODE_PRIVATE);
        SharedPreferences.Editor userKeyEditor = preferences.edit();
        userKeyEditor.putString(userNameKey, user.getUsername());
        userKeyEditor.apply();
    }


    public static void SetBuyStatus(NepTripPackage nepTripPackage) {
        if(nepTripPackage != null) {
            SharedPreferences preferences = c.getSharedPreferences(settingsFileName, c.MODE_PRIVATE);
            SharedPreferences.Editor keyEditor = preferences.edit();
            String curBuyString = GetBuyString();
            if(!curBuyString.toLowerCase().contains(nepTripPackage.getTitle().toLowerCase())) {
                keyEditor.putString(pckBuyDetailsKey, curBuyString + ";;;" + nepTripPackage.getTitle());
                keyEditor.apply();
            }
        }
    }

    public static void GoToHome() {
        GoToActivity(HomePage.class);
    }

    public static void GoToProfileSetup() {
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

    public static void ShowToast(String msg) {
        Toast.makeText(c, msg, Toast.LENGTH_SHORT).show();
    }

    public static void ShowAlert(String msg) {
        AlertDialog.Builder alert = new AlertDialog.Builder(c);
        alert.setMessage(msg);
        alert.show();
    }

    public static void LoadImage(Context ctx, ImageView iv, String imgUrl) {
        Glide.with(ctx)
                .load(imgUrl)
                .centerCrop()
                .into(iv);
    }

    public static boolean IsOnline() {
        ConnectivityManager connMgr = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        boolean status = networkInfo != null && networkInfo.isConnected();
        if (!status)
            ShowAlert("Please make sure that you are connected to internet.");
        return (status);
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

    public static void ClearLocalUser() {
        SharedPreferences preferences = c.getSharedPreferences(settingsFileName, c.MODE_PRIVATE);
        SharedPreferences.Editor settingsEditor = preferences.edit();
        settingsEditor.putString(userNameKey, "");
        settingsEditor.putString(pckBuyDetailsKey, ""); // TODO: MAINTAIN BUY HSITORY EVEN ON USER LOGOUT -> PUSH IT TO THE SERVER MAYBE
        settingsEditor.apply();
    }
}
