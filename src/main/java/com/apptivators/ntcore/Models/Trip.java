package com.apptivators.ntcore.Models;

import java.io.Serializable;

/**
 * Created by Pratik on 12/4/2015.
 */
public class Trip implements Serializable{
    String title;
    String vendor;
    String startPoint;
    String endPoint;
    String venue;
    int cost;
    String startTime;
    String endTime;
    String imgName;
    String noOfAttendees;
    String category;
    String description;
    int attendees;
    public String ID;


    public Trip(){}
    public Trip(String title, String vendor, String startPoint, String endPoint, String venue, int cost, String startTime, String endTime, String imgName, String noOfAttendees, String category, String description) {
        this.title = title;
        this.vendor = vendor;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.venue = venue;
        this.cost = cost;
        this.startTime = startTime;
        this.endTime = endTime;
        this.imgName = imgName;
        this.noOfAttendees = noOfAttendees;
        this.category = category;
        this.description = description;
    }

    public int getAttendees()
    {
        return attendees;
    }

    public void setAttendees(int attendees)
    {
        this.attendees = attendees;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getNoOfAttendees() {
        return noOfAttendees;
    }

    public void setNoOfAttendees(String noOfAttendees) {
        this.noOfAttendees = noOfAttendees;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
