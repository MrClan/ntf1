package com.apptivators.ntcore.Models;

/**
 * Created on 12/7/2015
 * by MrClan<justmepratik@gmail.com>
 */
public class EventModel {

    String Title;
    String Categories;
    String StartDate;
    String EndDate;
    String City;
    String Description;
    String BudgetType;
    String Duration;
    String Cost;
    String TripRoute;
    String Accomodation;
    String TransportationMode;
    DailyIteneraryModel DailyItenerary;

    public String getTitle() {
        return Title;
    }

    public String getCategories() {
        return Categories;
    }

    public String getStartDate() {
        return StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public String getCity() {
        return City;
    }

    public String getDescription() {
        return Description;
    }

    public String getBudgetType() {
        return BudgetType;
    }

    public String getDuration() {
        return Duration;
    }

    public String getCost() {
        return Cost;
    }

    public String getTripRoute() {
        return TripRoute;
    }

    public String getAccomodation() {
        return Accomodation;
    }

    public String getTransportationMode() {
        return TransportationMode;
    }

    public DailyIteneraryModel getDailyItenerary() {
        return DailyItenerary;
    }
}
