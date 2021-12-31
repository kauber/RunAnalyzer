package com.example.analyzeruns;
import java.text.DecimalFormat;
import java.util.*;

public class MainRunAnalyzer {
    public static void main(String[] args) {
        RunsParser rt = new RunsParser();
        ArrayList<Run> myRuns = rt.runLoader("C:/Users/valen/IdeaProjects/RunningAnalyzer/data/Activities_last.csv");
        int runSum = 0;
        for (Run r : myRuns) {
            runSum += r.getAvgPace();
        }

        System.out.println("Total number of runs: " + myRuns.size());
        System.out.println("Overall average pace per km in secs: " + runSum / myRuns.size());
        int avgTime = runSum / myRuns.size();
        System.out.println("Overall average 1k pace in minutes: " + runTimeFormatter(avgTime));
        System.out.println("Total distance ran: " + totDistance(myRuns));
        System.out.println("Total calories burnt: " + totCalories(myRuns));
        System.out.println("Average Hr for all runs: " + avgHrCalculator(myRuns));
        // let's see the 3 fastest 5ks
        System.out.println("Fastest 5ks:");
        printFastestRuns(myRuns, 5, 5.0);
        // let's see the 3 fastest 3 miles (4.83 miles)
        System.out.println("Fastest 3 miles:");
        printFastestRuns(myRuns, 5, 4.83);
        // fastest 4 miles (6.44 k)
        System.out.println("Fastest 4 miles");
        printFastestRuns(myRuns, 5, 6.44);

        Filter distanceF = new DistanceFilter(4.99, 5.01);
        ArrayList<Run> fiveKRuns = filter(myRuns, distanceF);
        System.out.println("Average time when running 5k: " + avgTimeCalculator(fiveKRuns));
        Filter distanceF2 = new DistanceFilter(6.43, 6.45);
        ArrayList<Run> fourMilesRuns = filter(myRuns, distanceF2);
        System.out.println("Average time when running 4 miles: " + avgTimeCalculator(fourMilesRuns));
        Filter distanceF3 = new DistanceFilter(9.99, 13.02);
        ArrayList<Run> tenKRuns = filter(myRuns, distanceF3);
        System.out.println("Average time when running more than 10k: " + avgTimeCalculator(tenKRuns));
    }

    public static String runTimeFormatter(int runtime) {
        // takes run time in seconds and returns string of minutes and seconds, e.g. 305 -> 5 mins 5 secs
        //if run time > 1 hour
        if (runtime > 3600) {
            int hours = runtime / 3600;
            int secs = runtime - 3600;
            // more than 1 hour and 1 minute
            if (secs > 60) {
                int minutes = secs / 60;
                int seconds = minutes % 60;
                return hours + " hour " + minutes + " mins " + seconds + " secs";
            }
            return hours + " hour " + secs + " secs";
        }
        // if below hour
        else {
            int minutes = runtime / 60;
            int seconds = runtime % 60;
            return minutes + " mins " + seconds + " secs";
        }
    }

    public static String totDistance(ArrayList<Run> allRuns){
        // given an arraylist of runs, returns the total distance ran
        double totDist = 0.0;
        for (Run r: allRuns){
            totDist+=r.getDistance();
        }
        DecimalFormat df = new DecimalFormat("###.##");
        return df.format(totDist) + " km";
    }

    public static int totCalories(ArrayList<Run> allRuns){
        // given an arraylist of runs, returns the total calories burnt
        int totCal = 0;
        for (Run r: allRuns){
            totCal+=r.getCalories();
        }
        return totCal;
    }

    public static String avgTimeCalculator(ArrayList<Run> allRuns){
        //returns the average runtime calculated on a list of runs
        int totRuns = allRuns.size();
        int pace = 0;
        for (Run r: allRuns){
            pace += r.getTime();
        }
        int avgPace = pace/totRuns;
        return runTimeFormatter(avgPace);
    }

    public static int avgHrCalculator(ArrayList<Run> allRuns){
        //returns the average runtime calculated on a list of runs
        int totRuns = allRuns.size();
        int hr = 0;
        for (Run r: allRuns){
            hr += r.getAvgHr();
        }
        int avgHr = hr/totRuns;
        return avgHr;
    }

    public static ArrayList<Run> printFastestRuns(ArrayList<Run> myRuns, int numRuns, double distance){
        // returns a number (numRuns) of runs ranked from fastest to slowest given a distance
        Filter distFilter = new DistanceFilter(distance-0.1, distance+0.1);
        ArrayList<Run> theRuns = filter(myRuns,distFilter);
        Collections.sort(theRuns);
        for (int i=0;i<numRuns;i++) {
            System.out.println("Run on: " + theRuns.get(i).getDate() + " Time: " + runTimeFormatter(theRuns.get(i).getTime()) +
                    " Average pace: " + runTimeFormatter(theRuns.get(i).getAvgPace()));

        }
        return theRuns;
    }



    public static ArrayList<Run> filter(ArrayList<Run> runData, Filter f) {
        // filter method that returns an arraylist of runs that satisfies a filter f
        ArrayList<Run> answer = new ArrayList<>();
        for(Run r : runData) {
            if (f.satisfies(r)) {
                answer.add(r);
            }
        }
        return answer;
    }
}
