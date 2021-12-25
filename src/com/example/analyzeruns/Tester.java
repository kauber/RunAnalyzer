package com.example.analyzeruns;
import java.util.*;

public class Tester {
    public static void main(String[] args) {
        RunsParser rt = new RunsParser();
        rt.runLoader("C:/Users/valen/IdeaProjects/RunningAnalyzer/data/Activities.csv");
        //System.out.println(rt.timeToSecs("7:20"));
        ArrayList<Run> myRuns = rt.runLoader("C:/Users/valen/IdeaProjects/RunningAnalyzer/data/Activities.csv");
        int runSum = 0;
        for (Run r: myRuns) {
            runSum+=r.getAvgPace();

        }

        System.out.println("Overall average pace: " + runSum/myRuns.size());
        System.out.println("Overall average pace in minutes: " + (runSum/myRuns.size())/60.0);


    }
}
