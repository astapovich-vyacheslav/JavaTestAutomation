package com.solvd.it.apps;

import com.solvd.it.requirements.Requirement;

import java.util.ArrayList;

public class App {
    private String name;
    private ArrayList<Requirement> requirements = new ArrayList<>();
    private int rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Requirement> getRequirements() {
        return requirements;
    }

    public void addRequirement(Requirement requirement) {
        this.requirements.add(requirement);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating > 10)
            rating = 10;
        if (rating < 1)
            rating = 1;
        this.rating = rating;
    }

    public App(String name, ArrayList<Requirement> requirements) {
        this.name = name;
        this.requirements = requirements;
    }

    public App(String name) {
        this.name = name;
    }
}
