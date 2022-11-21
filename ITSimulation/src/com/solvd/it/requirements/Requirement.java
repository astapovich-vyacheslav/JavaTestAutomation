package com.solvd.it.requirements;

public class Requirement {
    private String deadline;

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    private int budget;

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Requirement(String deadline, int budget) {
        this.deadline = deadline;
        this.budget = budget;
    }
}
