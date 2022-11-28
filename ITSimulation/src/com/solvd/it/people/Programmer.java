package com.solvd.it.people;

import java.util.Date;

public class Programmer extends Worker {
    enum Rank {
        JUNIOR,
        SENIOR,
        TECHLEAD
    }

    private Rank rank;
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

    public Programmer(Worker worker) {
        super(worker.getName(), worker.getDateOfBirth(), worker.getId(), worker.getProjectIncome());
    }


    @Override
    public boolean doAction() {
        System.out.println(this.getName() + " is working");
        return true;
    }

    public Rank raise() {
        if (this.rank == Rank.JUNIOR)
            this.rank = Rank.SENIOR;
        if (this.rank == Rank.SENIOR)
            this.rank = Rank.TECHLEAD;
        return this.rank;
    }
}