package com.solvd.it.people;

import com.solvd.it.requirements.Requirement;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Client extends Person {
    private ArrayList<Requirement> request = new ArrayList<>();
    private String projectName;
    private final int id;

    public int getId() {
        return id;
    }

    public int getSuggestedPrice() {
        return suggestedPrice;
    }

    public void setSuggestedPrice(int suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
    }

    private int suggestedPrice;

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

    @Override
    public String toString() {
        return "Client{" +
                "request=" + request +
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
        return id == client.id && suggestedPrice == client.suggestedPrice &&
                request.equals(client.request) && projectName.equals(client.projectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(request, projectName, id, suggestedPrice);
    }
}
