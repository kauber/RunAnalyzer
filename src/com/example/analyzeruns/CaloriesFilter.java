package com.example.analyzeruns;

public class CaloriesFilter implements Filter {
    private double minCalories;
    private double maxCalories;
    private String name;
    public CaloriesFilter(double minCal, double maxCal) {
        minCalories = minCal;
        maxCalories = maxCal;
        name = "CaloriesFilter";
    }

    @Override
    public boolean satisfies(Run r) {
        return r.getCalories() >= minCalories && r.getCalories() <= maxCalories;
    }
}
