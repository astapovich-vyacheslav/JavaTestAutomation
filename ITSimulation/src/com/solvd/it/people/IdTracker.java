package com.solvd.it.people;

public class IdTracker {
    private static int id = 0;

    public static int getId() {
        return id++;
    }
}
