package com.apptivators.ntcore.Models;

/**
 * Created by Pratik on 12/8/2015.
 */
public class Event {
    public String Host;
    public String accomodation;
    public String budgettype;
    public String categories;
    public String city;
    public String cost;
    public DailyIteneraryModel dailyitinerary;
    public String description;
    public String duration;
    public String enddate;
    public String startdate;
    public String title;
    public String transportationmode;
    public String triproute;
    public String averagetravelperday;

    public String getAveragetravelperday() {
        return averagetravelperday;
    }

    public String getDescription() {
        return description;
    }

    public String getDuration() {
        return duration;
    }

    public String getEnddate() {
        return enddate;
    }

    public String getStartdate() {
        return startdate;
    }

    public String getTitle() {
        return title;
    }

    public String getTransportationmode() {
        return transportationmode;
    }

    public String getTriproute() {
        return triproute;
    }

    public String getAccomodation() {
        return accomodation;
    }

    public String getBudgettype() {
        return budgettype;
    }

    public String getCategories() {
        return categories;
    }

    public String getCity() {
        return city;
    }

    public String getCost() {
        return cost;
    }

    public DailyIteneraryModel getDailyitinerary() {
        return dailyitinerary;
    }
}
