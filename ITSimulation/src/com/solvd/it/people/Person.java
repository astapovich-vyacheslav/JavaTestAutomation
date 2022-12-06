package com.solvd.it.people;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class Person {
    static final int DAYS_IN_YEAR = 365;
    private String name;
    private Date dateOfBirth;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Person(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public final int getAge() throws EUnderagePerson {
        Date now = new Date();
        long diffInMilliseconds = Math.abs(now.getTime() - dateOfBirth.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS) / DAYS_IN_YEAR;
        int result = (int) diff;
        if (result < 18) {
            throw new EUnderagePerson();
        }
        return (int) diff;

    }

    public static class EUnderagePerson extends Exception {

    }

    abstract boolean doAction();
}
