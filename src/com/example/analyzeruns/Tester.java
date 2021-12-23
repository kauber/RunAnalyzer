package com.example.analyzeruns;

public class Tester {
    public static void main(String[] args) {
        RunsParser rt = new RunsParser();
        rt.runLoader("C:/Users/valen/IdeaProjects/RunningAnalyzer/data/Activities.csv");
        //System.out.println(rt.timeToSecs("7:20"));


    }
}
