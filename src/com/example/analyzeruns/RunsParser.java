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
                    int calories = Integer.parseInt(columns[5]); // fix, bug when comma in number, i.e. > 1000
                    //int calories = Integer.parseInt(columns[5].replace(",",""));
                    int time = timeToSecs(columns[6]);
                    int avgHr = Integer.parseInt(columns[7]);
                    int maxHr = Integer.parseInt(columns[8]);
                    int avgCadence = Integer.parseInt(columns[10]);
                    int maxCadence = Integer.parseInt(columns[11]);
                    int avgPace = timeToSecs(columns[12]);
                    int maxPace = timeToSecs(columns[13]);
                    String elapsedTime = columns[30];
                    //System.out.println(elapsedTime);
                    int theElapsedTime = timeToSecs(elapsedTime);

                    Run myRun = new Run(date, title, distance, calories, time, avgHr, maxHr, avgCadence,
                            maxCadence,avgPace, maxPace,theElapsedTime);
                    //System.out.println(myRun);
                    myRuns.add(myRun);
                }
            } catch (IOException e) {
                System.out.println("File not Found");
//            e.printStackTrace();


            }
            //System.out.println("number of runs: " + myRuns.size());

            return myRuns;

        }

//        public int timeToSecs(String myTime){
//            int myInd = myTime.indexOf(":");
//            int min = Integer.parseInt(myTime.substring(0,myInd));
//
//            int secs = Integer.parseInt(myTime.substring(myInd+1));
//
//            return min*60 + secs;
//        }

    private int timeToSecs(String myTime){
            // helper method to compute seconds from run time format ()
        if (myTime.length()>5){
            int firstInd = myTime.indexOf(":");
            int Hour = Integer.parseInt(myTime.substring(0,firstInd));
            int secondInd = myTime.indexOf(":",firstInd+1);
            int min = Integer.parseInt(myTime.substring(firstInd+1,secondInd));
            int secs = Integer.parseInt(myTime.substring(secondInd+1,secondInd+3)); // secondInd+3 to prevent decimals
            //System.out.println((Hour * 3600) + (min * 60) + secs);
            return (Hour * 3600) + (min * 60) + secs;

        }
        int myInd = myTime.indexOf(":");
        int min = Integer.parseInt(myTime.substring(0,myInd));
        int secs = Integer.parseInt(myTime.substring(myInd+1));
        return (min * 60) + secs;
    }

}

//Integer(value).toString() for leading zeros