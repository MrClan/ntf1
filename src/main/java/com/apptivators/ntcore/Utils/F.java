package com.apptivators.ntcore.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AutoCompleteTextView;

import com.apptivators.ntcore.HomePage;
import com.apptivators.ntcore.Models.Trip;
import com.apptivators.ntcore.Models.TripType;
import com.apptivators.ntcore.Models.User;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Pratik on 12/4/2015.
 * Firebase related codes goes here
 */
public class F {

    public final static String rootNode = "https://ntf1.firebaseio.com/v1";//https://neptrip.firebaseio.com/v1";
    public final static String usersNode = "/users";
    public final static String eventsRefNode = "/events";
    public final static String romaticCitiesNode = "/RomanticCities";
    public final static String adventureCitiesNode = "/adventureCities";
    public final static String religiousCitiesNode = "/ReligiousCities";
    public final static String businessCitiesNode = "/BusinessCities";
    public final static String casualCitiesNode = "/CasualCities";
    public final static String exploreCitiesNode = "/ExploreCities";
    public final static String mountainCitiesNode = "/MountainCities";


    public final static Map<TripType, String> NodeMaps = new HashMap<TripType, String>() {
        {
            put(TripType.ADVENTURE, F.adventureCitiesNode);
            put(TripType.ROMANTIC, F.romaticCitiesNode);
            put(TripType.CASUAL, F.casualCitiesNode);
            put(TripType.EXPLORING, F.exploreCitiesNode);
            put(TripType.MOUNTAINEERING, F.mountainCitiesNode);
        }
    };

    public static boolean CheckIfUserExists(final String username, final View view, final AutoCompleteTextView autoCompleteTextView, final Context c, final boolean loginIfUserExists) {
        U.ShowToast("Checking for user: " + username);
        final Firebase searchUserNodeRef = new Firebase(rootNode + usersNode + "/" + username.toLowerCase());
        searchUserNodeRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (loginIfUserExists) {
                    if (dataSnapshot.getValue() != null) // unique username, hence proceed to user creation
                    {
                        U.ShowToast("Logging in as " + username);
                        //final Firebase userNodeRef = new Firebase(rootNode + usersNode);
                        //Firebase newUserRef = userNodeRef.push();
                        User u = dataSnapshot.getValue(User.class); // Read the user, and set it's username to the localUserDatabase
                        U.SetLocalUser(u);
                        Intent i = new Intent(c, HomePage.class);
                        c.startActivity(i);
                        ((Activity) c).finish();
                    } else {
                        U.ShowAlert("No user with username: " + username + " found. How about signing up as new user ?");
                        U.ShowProgress(true, view);
                        autoCompleteTextView.setError("Username not found");
                        autoCompleteTextView.requestFocus();
                    }
                } else {
                    if (dataSnapshot.getValue() == null) // unique username, hence proceed to user creation
                    {
                        U.ShowToast("Registering new user...");
                        //final Firebase userNodeRef = new Firebase(rootNode + usersNode);
                        //Firebase newUserRef = userNodeRef.push();
                        User u = new User(username.toLowerCase(), "", "");
                        searchUserNodeRef.setValue(u);
                        U.SetLocalUser(u);
                        Intent i = new Intent(c, HomePage.class);
                        c.startActivity(i);
                        ((Activity) c).finish();
                    } else {
                        U.ShowAlert("A user with username: " + username + " already exists. Please pick a different one.");
                        U.ShowProgress(true, view);
                        autoCompleteTextView.setError("Username already taken");
                        autoCompleteTextView.requestFocus();
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        return false;
    }

    public static void GetTrips(TripType tripType) {


    }

    public static void AddTrips() {
        /*String title, String vendor, String startPoint, String endPoint, String venue, String cost, String startTime, String endTime, String imgName, String noOfAttendees, String category, String description*/
        List<Trip> trips = new ArrayList<Trip>(Arrays.asList(
                new Trip("Tilicho Trip", "Global Travels", "Lazimpat", "Dhulikhel", "Nagarkot", 5700, "9th Dec", "9th Dec", "http://res.cloudinary.com/pratik/image/upload/v1449251052/8_lh6vci.jpg", "Any", "Mountaineering", "Explore the uncharted terrains of Nepal. Places never been walked before. Experience most pristine form of nature."),
                new Trip("All Nepal Tour", "MyNepal Travels", "Lazimpat", "Dhulikhel", "Nagarkot", 84000, "9th Dec", "9th Dec", "http://res.cloudinary.com/pratik/image/upload/v1449251052/7_zo8gz2.jpg", "Any", "Mountaineering", "Explore the uncharted terrains of Nepal. Places never been walked before. Experience most pristine form of nature."),
                new Trip("Sky diving", "Whatever Travels", "Lazimpat", "Dhulikhel", "Nagarkot", 400000, "9th Dec", "9th Dec", "http://res.cloudinary.com/pratik/image/upload/v1449251051/6_agm1as.jpg", "Any", "Mountaineering", "Explore the uncharted terrains of Nepal. Places never been walked before. Experience most pristine form of nature."),
                new Trip("Bungy @ Last Resort", "Tatopani Travels", "Thamel", "Dhulikhel", "Nagarkot", 7200, "9th Dec", "9th Dec", "http://res.cloudinary.com/pratik/image/upload/v1449251050/5_eve2ua.jpg", "Any", "Mountaineering", "Explore the uncharted terrains of Nepal. Places never been walked before. Experience most pristine form of nature."),
                new Trip("Tilicho Trip", "New Travels", "Lazimpat", "Dhulikhel", "Nagarkot", 15000, "9th Dec", "9th Dec", "http://res.cloudinary.com/pratik/image/upload/v1449251051/4_n5ekjl.jpg", "Any", "Mountaineering", "Explore the uncharted terrains of Nepal. Places never been walked before. Experience most pristine form of nature."),
                new Trip("Water Touch Bungy", "Bungy Travels", "Lazimpat", "Dhulikhel", "Nagarkot", 27000, "9th Dec", "9th Dec", "http://res.cloudinary.com/pratik/image/upload/v1449251053/3_rlsxwg.jpg", "Any", "Mountaineering", "Explore the uncharted terrains of Nepal. Places never been walked before. Experience most pristine form of nature."),
                new Trip("Paragliding Trip", "Pokhara Travels", "Lazimpat", "Dhulikhel", "Nagarkot", 57000, "9th Dec", "9th Dec", "http://res.cloudinary.com/pratik/image/upload/v1449251051/2_lje2gy.jpg", "Any", "Mountaineering", "Explore the uncharted terrains of Nepal. Places never been walked before. Experience most pristine form of nature."),
                new Trip("Temple Trip", "Religious Travels", "Lazimpat", "Dhulikhel", "Nagarkot", 75000, "9th Dec", "9th Dec", "http://res.cloudinary.com/pratik/image/upload/v1449251050/1_ruhlxe.jpg", "Any", "Mountaineering", "Explore the uncharted terrains of Nepal. Places never been walked before. Experience most pristine form of nature.")

        ));

        Firebase eventsRef = new Firebase(rootNode + eventsRefNode);

        for (Trip t : trips) {
            eventsRef.push().setValue(t);
        }
    }
}
