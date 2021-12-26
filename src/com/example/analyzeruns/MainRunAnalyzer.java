package com.example.analyzeruns;
import java.text.DecimalFormat;
import java.util.*;

public class MainRunAnalyzer {
    public static void main(String[] args) {
        RunsParser rt = new RunsParser();
        rt.runLoader("C:/Users/valen/IdeaProjects/RunningAnalyzer/data/Activities.csv");
        ArrayList<Run> myRuns = rt.runLoader("C:/Users/valen/IdeaProjects/RunningAnalyzer/data/Activities.csv");
        int runSum = 0;
        for (Run r: myRuns) {
            runSum+=r.getAvgPace();

        }

        System.out.println("Total runs: " + myRuns.size());

        System.out.println("Overall average pace per km in secs: " + runSum/myRuns.size());
        int avgTime = runSum/myRuns.size();
        System.out.println("Overall average 1k pace in minutes: " + runTimeFormatter(avgTime));
        System.out.println("Total distance ran: " + totDistance(myRuns));
        Filter distanceF = new DistanceFilter(5.0,5.0);
        ArrayList<Run> fiveKRuns = filter(myRuns,distanceF);
        for (Run r: fiveKRuns){
            System.out.println(r);
        }
        System.out.println("Average time when running 5k: " + avgTimeCalculator(fiveKRuns));



    }

    public static String runTimeFormatter(int runtime) {
        // takes run time in seconds and returns string of minutes and seconds, e.g. 305 -> 5 mins 5 secs
        int minutes = runtime/60;
        int seconds = runtime % 60;
        return minutes + " mins " + seconds + " secs";
    }

    public static String totDistance(ArrayList<Run> allRuns){
        double totDist = 0.0;
        for (Run r: allRuns){
            totDist+=r.getDistance();
        }
        DecimalFormat df = new DecimalFormat("###.##");
        return df.format(totDist) + " km";
    }

    public static String avgTimeCalculator(ArrayList<Run> allRuns){
        int totRuns = allRuns.size();
        int pace = 0;
        for (Run r: allRuns){
            pace += r.getTime();

        }

        int avgPace = pace/totRuns;

        return runTimeFormatter(avgPace);
    }

    public static ArrayList<Run> filter(ArrayList<Run> runData, Filter f) {
        ArrayList<Run> answer = new ArrayList<Run>();
        for(Run r : runData) {
            if (f.satisfies(r)) {
                answer.add(r);
            }
        }
        return answer;
    }
}
