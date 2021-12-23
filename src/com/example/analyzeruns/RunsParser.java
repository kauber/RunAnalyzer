package com.example.analyzeruns;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class RunsParser {
        // method to load csv with run data, and return an arraylist of runs
        public ArrayList<Run> runLoader(String filename) {
            ArrayList<Run> myRuns = new ArrayList<Run>();
            try {

                //String file = "D:/Java/MovieRecommender/data/ratedmovies_short.csv";//file path
                FileReader fr = new FileReader(filename);
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                String line;
                while ((line = br.readLine()) != null) {

                    String[] columns = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                    String date = columns[1];
                    String title = columns[3];
                    double distance = Double.parseDouble(columns[4]);
                    int calories = Integer.parseInt(columns[5]);
                    String time = columns[6];
                    int avgHr = Integer.parseInt(columns[7]);
                    int maxHr = Integer.parseInt(columns[8]);
                    int avgCadence = Integer.parseInt(columns[10]);
                    int maxCadence = Integer.parseInt(columns[11]);
                    int avgPace = timeToSecs(columns[12]);
                    System.out.println(avgPace);
                    int maxPace = timeToSecs(columns[13]);
                    System.out.println(maxPace);
                    int movTime = timeToSecs(columns[29]);

                    Run myRun = new Run(date, title, distance, calories, time, avgHr, maxHr, avgCadence,
                            maxCadence,avgPace, maxPace,movTime);
                    System.out.println(myRun);
                    myRuns.add(myRun);
                }
            } catch (IOException e) {
                System.out.println("File not Found");
//            e.printStackTrace();


            }

            return myRuns;

        }

        public int timeToSecs(String myTime){
            int myInd = myTime.indexOf(":");
            int min = Integer.parseInt(myTime.substring(0,myInd));

            int secs = Integer.parseInt(myTime.substring(myInd+1));

            return min*60 + secs;
        }

}

