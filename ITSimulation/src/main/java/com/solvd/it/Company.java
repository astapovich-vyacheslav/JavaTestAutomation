package com.solvd.it;

import com.solvd.it.apps.AllApps;
import com.solvd.it.apps.App;
import com.solvd.it.people.Client;
import com.solvd.it.people.Director;
import com.solvd.it.people.Manager;
import com.solvd.it.people.Programmer;

import java.security.KeyPair;
import java.util.*;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public final class Company {
    private static final Logger log = LogManager.getLogger(Company.class);
    public static int totalOutcome = 0;
    private LinkedList<Programmer> programmers = new LinkedList<>();
    private Manager manager;
    private Director director;
    private AllApps apps = new AllApps();
    private ArrayList<Client> clients = new ArrayList<>();

    enum ProjectState {
        NOT_READY,
        READY,
        NOT_PROFITABLE
    }

    private Map<Client, ProjectState> projectStates = new HashMap<>();

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
        totalOutcome += manager.getProjectIncome();
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
        totalOutcome += director.getProjectIncome();
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
            totalOutcome += programmer.getProjectIncome();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean removeProgrammer(Programmer programmer) {
        try {
            programmers.remove(programmer);
            totalOutcome -= programmer.getProjectIncome();
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
        log.info("Company starts working!");
    }

    public Company() {
    }

    public int completeWork() {
        int result = 0;
        for (Map.Entry<Client, ProjectState> entry :
                projectStates.entrySet()) {
            if (entry.getValue() != ProjectState.READY) {
                //this.manager.setTotalOutcome(this.getTotalOutcome());
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
                    this.apps.addApp(new App(entry.getKey().getProjectName()));
                    result += manager.getProfitFromClient(entry.getKey());
                }
            }
        }
        this.director.doAction();
        return result;
    }
}
