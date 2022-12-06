package com.solvd.it.people;

import org.apache.log4j.Logger;

import java.util.Date;

public class Programmer extends Worker {
    private static final Logger log = Logger.getLogger(Programmer.class);

    enum Rank {
        JUNIOR,
        SENIOR,
        TECHLEAD;
        private int minimumSalary;

        Rank() {
        }

        int getMinimumSalary() {
            return this.minimumSalary;
        }

        void setMinimumSalary(int minS) {
            this.minimumSalary = minS;
        }
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
        log.info(this.getName() + " is working");
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
