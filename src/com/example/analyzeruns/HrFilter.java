package com.example.analyzeruns;

public class HrFilter implements Filter {
    private double minHr;
    private double maxHr;
    private String name;
    public HrFilter(double minimHr, double maxiHr) {
        minHr = minimHr;
        maxHr = maxiHr;
        name = "HrFilter";
    }

    @Override
    public boolean satisfies(Run r) {
        return r.getCalories() >= minHr && r.getCalories() <= maxHr;
    }
}
