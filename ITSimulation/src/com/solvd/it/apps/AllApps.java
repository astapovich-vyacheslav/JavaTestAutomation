package com.solvd.it.apps;

import java.util.ArrayList;

public class AllApps {
    private ArrayList<App> allApps = new ArrayList<>();
    private double averageRating;

    public ArrayList<App> getAllApps() {
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

    public AllApps(ArrayList<App> allApps) {
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
        this.averageRating = (double) ratingSum / appsCount;
        return this.averageRating;
    }
}
