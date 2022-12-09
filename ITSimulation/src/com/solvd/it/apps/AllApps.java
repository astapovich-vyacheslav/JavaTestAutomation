package com.solvd.it.apps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class AllApps {
    private HashSet<App> allApps = new HashSet<>();
    private double averageRating;

    public HashSet<App> getAllApps() {
        return allApps;
    }

    public boolean addApp(App app) {
        try {
            this.allApps.add(app);
            this.countAverageRating();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public AllApps(HashSet<App> allApps) {
        this.allApps = allApps;
    }

    public AllApps() {
    }

    private double countAverageRating() {
        int ratingSum = 0;
        int appsCount = allApps.size();
        for (App app :
                allApps) {
            ratingSum += app.getRating();
        }
        try {
            this.averageRating = (double) ratingSum / appsCount;
            return this.averageRating;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
}
