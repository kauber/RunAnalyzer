package com.example.analyzeruns;
import java.util.ArrayList;
import java.util.Arrays;

// An immutable passive data object (PDO) to represent item data
public class Run {
    private String date;
    private String title;
    private double distance;
    private int calories;
    private String time;
    private int avgHr;
    private int maxHr;
    private int avgCadence;
    private int maxCadence;
    private int avgPace;
    private int maxPace;// this has to be converted from mins to seconds in constructor
    private int elapsedTime; // this has to be converted from mins to seconds in constructor


    public Run (String theDate, String theTitle, double theDistance, int theCalories, String theTime,
                int theAvgHr, int theMaxHr, int theAvgCadence, int theMaxCadence, int theAvgPace, int theMaxPace,
                int theElapsedTime) {
        // just in case data file contains extra whitespace
        date = theDate;
        title = theTitle;
        distance = theDistance;
        calories = theCalories;
        time = theTime;
        avgHr = theAvgHr;
        maxHr = theMaxHr;
        avgCadence = theAvgCadence;
        maxCadence = theMaxCadence;
        avgPace = theAvgPace;
        maxPace = theMaxPace;
        elapsedTime = theElapsedTime;

    }

    // Returns ID associated with this item
    public String getDate () {
        return date;
    }

    // Returns title of this item
    public String getTitle () {
        return title;
    }

    // Returns year in which this item was published
    public double getDistance () {
        return distance;
    }

    // Returns genres associated with this item
    public int getCalories () {
        return calories;
    }

    public String getTime(){
        return time;
    }

    public int getAvgHr(){
        return avgHr;
    }

    public int getMaxHr(){
        return maxHr;
    }

    public int getAvgCadence(){
        return avgCadence;
    }

    public int getMaxCadence(){
        return maxCadence;
    }

    public int getAvgPace(){
        return avgPace;
    }

    public int getMaxPace(){
        return maxPace;
    }

    public int getElapsedTime(){
        return elapsedTime;
    }



    // Returns a string of the item's information
    public String toString () {
        return String.format(date, title, distance, calories, time, avgHr, maxHr, avgCadence, maxCadence, avgPace,
                maxPace, elapsedTime);
    }
}

//public String toString () {
//        String result = "Movie [id=" + id + ", title=" + title + ", year=" + year;
//        result += ", genres= " + genres + "]";
//        return result;
//    }