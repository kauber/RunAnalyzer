package com.example.analyzeruns;

public class TimeFilter implements Filter{
    private int minTime;
    private int maxTime;
    private String name;
    public TimeFilter(int minT, int maxT) {
        minTime = minT;
        maxTime = maxT;
        name = "TimeFilter";
    }

    @Override
    public boolean satisfies(Run r) {
        return r.getTime() >= minTime && r.getTime() <= maxTime;
    }
}
