package com.solvd.it;

import com.solvd.it.apps.AllApps;
import com.solvd.it.apps.App;
import com.solvd.it.people.Client;
import com.solvd.it.people.Director;
import com.solvd.it.people.Manager;
import com.solvd.it.people.Programmer;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

public final class Company {
    private ArrayList<Programmer> programmers;
    private Manager manager;
    private Director director;
    private AllApps apps;
    private ArrayList<Client> clients;

    enum ProjectState {
        NOT_READY,
        READY,
        NOT_PROFITABLE
    }

    private Map<Client, ProjectState> projectStates;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public boolean addApp(App app) {
        try {
            apps.addApp(app);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean addProgrammer(Programmer programmer) {
        try {
            programmers.add(programmer);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean removeProgrammer(Programmer programmer) {
        try {
            programmers.remove(programmer);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean addClient(Client client) {
        try {
            clients.add(client);
            projectStates.put(client, ProjectState.NOT_READY);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    static {
        System.out.println("Company starts working!");
    }

    public Company() {
        clients = new ArrayList<>();
        programmers = new ArrayList<>();
        initializeProjectStates();
    }

    private boolean initializeProjectStates() {
        try {
            projectStates = new Hashtable<>();
            for (Client client :
                    clients) {
                projectStates.put(client, ProjectState.NOT_READY);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int completeWork() {
        int result = 0;
        for (Map.Entry<Client, ProjectState> entry :
                projectStates.entrySet()) {
            if (entry.getValue() != ProjectState.READY) {
                this.manager.setTotalOutcome(this.getTotalOutcome());
                this.manager.refreshClientMap(this.clients);
                this.manager.doAction();
                if (!this.manager.checkProfitability(entry.getKey())) {
                    entry.setValue(ProjectState.NOT_PROFITABLE);
                } else {
                    for (Programmer programmer :
                            programmers) {
                        programmer.doAction();
                    }
                    entry.setValue(ProjectState.READY);
                    result += manager.getProfitFromClient(entry.getKey());
                }
            }
        }
        this.director.doAction();
        return result;
    }

    private int getTotalOutcome() {
        int result = 0;
        result += this.director.getProjectIncome();
        result += this.manager.getProjectIncome();
        for (Programmer programmer :
                programmers) {
            result += programmer.getProjectIncome();
        }
        return result;
    }
}
