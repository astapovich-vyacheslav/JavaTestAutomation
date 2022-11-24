package com.solvd.it.requirements;

import java.util.Date;

public class Requirement {
    private Date deadline;

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    private int budget;

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Requirement(Date deadline, int budget) {
        this.deadline = deadline;
        this.budget = budget;
    }
}
