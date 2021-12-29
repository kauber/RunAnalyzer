package com.example.analyzeruns;

public class PaceFilter implements Filter{
    private int minPace;
    private int maxPace;
    private String name;
    public PaceFilter(int minRunPace, int maxRunPace) {
        minPace = minRunPace;
        maxPace = maxRunPace;
        name = "PaceFilter";
    }

    @Override
    public boolean satisfies(Run r) {
        return r.getAvgPace() >= minPace && r.getAvgPace() <= maxPace;
    }
}
