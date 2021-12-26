package com.example.analyzeruns;

public class DistanceFilter implements Filter {
    private double minDistance;
    private double maxDistance;
    private String name;
    public DistanceFilter(double minDis, double maxDis) {
        minDistance = minDis;
        maxDistance = maxDis;
        name = "DistanceFilter";
    }

    @Override
    public boolean satisfies(Run r) {
        return r.getDistance() >= minDistance && r.getDistance() <= maxDistance;
    }
}
