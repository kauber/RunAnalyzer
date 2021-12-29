package com.example.analyzeruns;
import java.util.ArrayList;
import java.util.Arrays;

// An immutable passive data object (PDO) to represent item data
public class Run implements Comparable<Run> {
    private String date;
    private String title;
    private double distance;
    private int calories;
    private int time;
    private int avgHr;
    private int maxHr;
    private int avgCadence;
    private int maxCadence;
    private int avgPace;
    private int maxPace;// this has to be converted from mins to seconds in constructor
    //private int elapsedTime; // this has to be converted from mins to seconds in constructor


    public Run (String theDate, String theTitle, double theDistance, int theCalories, int theTime,
                int theAvgHr, int theMaxHr, int theAvgCadence, int theMaxCadence, int theAvgPace, int theMaxPace) {
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
        //elapsedTime = theElapsedTime;

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

    public int getTime(){
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


    //public int getElapsedTime(){
        //return elapsedTime;
    }



    // Returns a string of the item's information
    public String toString () {
        return "Run [date=" + date + ", distance=" + distance + ", time=" + time + ", average pace=" + avgPace +
                ", max pace=" + maxPace + ", calories=" + calories +  ", avg heart rate=" + avgHr + ", max heart rate="
                + maxHr + " , average cadence=" + avgCadence + ", max cadence=" + maxCadence  + "]";
    }

    public int compareTo(Run other){
        // compare to method to sort runs by average pace
        if (avgPace < other.avgPace){
            return -1;
        }
        return 1;
    }
}