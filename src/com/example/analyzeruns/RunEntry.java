package com.example.analyzeruns;

public class RunEntry {
    private String runDate;
    private String hourOfDay;
    private Double distance;
    private int caloriesBurnt;
    private int time;
    private int avgHR;
    private int avgCadence;
    private int avgPaceKm;
    private int avgPaceMile;
    private int bestPace;

    public RunEntry(String d, String h, Double dist, int cal, int t, int hr, int cad, int avgPKm,
                    int avgPMile, int bestP) {

        runDate = d;
        hourOfDay = h;
        distance = dist;
        caloriesBurnt = cal;
        time = t;
        avgHR = hr;
        avgCadence = cad;
        avgPaceKm = avgPKm;
        avgPaceMile = avgPMile;
        bestPace = bestP;
    }

    public String getDate() {
        return runDate;

    }

    public String getHour(){
        return hourOfDay;
    }

    public Double getDistance(){
        return distance;
    }

    public int getCaloriesBurnt(){
        return caloriesBurnt;
    }

    public int getTime(){
        return time;
    }

    public int getAvgHR(){
        return avgHR;
    }

    public int getAvgCad(){
        return avgCadence;
    }

    public int getAvgPaceKm(){
        return avgPaceKm;
    }

    public int getAvgPaceMile(){
        return avgPaceMile;
    }

    public int getBestPace(){
        return bestPace;
    }

    public String toString(){
        return String.format(runDate, hourOfDay, distance, caloriesBurnt, time, avgHR, avgCadence, avgPaceKm, avgPaceMile, bestPace);
    }

    }




