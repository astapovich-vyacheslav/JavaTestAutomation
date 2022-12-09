package com.solvd.it.people;

import com.solvd.it.apps.App;
import com.solvd.it.requirements.Requirement;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Client extends Person {
    private ArrayList<Requirement> request = new ArrayList<>();
    private String projectName;
    private final int id;
    private int suggestedPrice;

    public int getId() {
        return id;
    }

    public int getSuggestedPrice() {
        return suggestedPrice;
    }

    public void setSuggestedPrice(int suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
    }

    public ArrayList<Requirement> getRequest() {
        return this.request;
    }

    public void setRequest(ArrayList<Requirement> request) {
        this.request = request;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Client(String name, Date dateOfBirth, int id, ArrayList<Requirement> request, String projectName, int suggestedPrice) {
        super(name, dateOfBirth);
        this.id = id;
        this.request = request;
        this.projectName = projectName;
        this.suggestedPrice = suggestedPrice;
    }

    public Client(String name, Date dateOfBirth, int id) {
        super(name, dateOfBirth);
        this.id = id;
    }


    @Override
    public String toString() {
        return "Client{" +
                "name=" + getName() +
                ", date of birth=" + getDateOfBirth().toString() +
                ", request=" + request +
                ", projectName='" + projectName + '\'' +
                ", id=" + id +
                ", suggestedPrice=" + suggestedPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(getName(), client.getName()) && getDateOfBirth() == client.getDateOfBirth() && id == client.id && suggestedPrice == client.suggestedPrice &&
                request.equals(client.request) && projectName.equals(client.projectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(request, projectName, id, suggestedPrice);
    }

    @Override
    public boolean doAction(/*App app, int rating*/) {
        //app.setRating(rating);
        return true;
    }
}
