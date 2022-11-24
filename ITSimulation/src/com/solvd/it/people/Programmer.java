package com.solvd.it.people;

import java.util.Date;

public class Programmer extends Worker {
    private String usedTechnology;

    public String getUsedTechnology() {
        return usedTechnology;
    }

    public void setUsedTechnology(String usedTechnology) {
        this.usedTechnology = usedTechnology;
    }

    public Programmer(String name, Date dateOfBirth, int id, int projectIncome, String usedTechnology) {
        super(name, dateOfBirth, id, projectIncome);
        this.usedTechnology = usedTechnology;
    }


    @Override
    boolean work() {
        System.out.println("Programmer is working");
        return true;
    }
}
