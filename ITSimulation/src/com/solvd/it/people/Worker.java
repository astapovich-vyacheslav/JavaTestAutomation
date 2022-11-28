package com.solvd.it.people;

import java.util.Date;
import java.util.Objects;

public class Worker extends Person {
    private int projectIncome;
    private final int id;
    private int totalIncome = 0;

    public int getTotalIncome() {
        return this.totalIncome;
    }

    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    public int getProjectIncome() {
        return this.projectIncome;
    }

    public void setProjectIncome(int projectIncome) {
        this.projectIncome = projectIncome;
    }

    public int getId() {
        return id;
    }

    public Worker(String name, Date dateOfBirth, int id, int projectIncome) {
        super(name, dateOfBirth);
        this.id = id;
        this.projectIncome = projectIncome;
    }

    int getIncome(int income) {
        this.totalIncome += income;
        return this.totalIncome;
    }


    @Override
    public String toString() {
        return "Worker{" +
                "projectIncome=" + projectIncome +
                ", id=" + id +
                ", totalIncome=" + totalIncome +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return projectIncome == worker.projectIncome && id == worker.id && totalIncome == worker.totalIncome;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectIncome, id, totalIncome);
    }

    @Override
    boolean doAction() {
        return false;
    }
}
