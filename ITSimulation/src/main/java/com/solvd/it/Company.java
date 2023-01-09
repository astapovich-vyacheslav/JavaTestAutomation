package com.solvd.it;

import com.solvd.it.apps.AllApps;
import com.solvd.it.apps.App;
import com.solvd.it.people.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.KeyPair;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.solvd.it.utils.IAction;
import jdk.dynalink.Operation;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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

    Predicate<Client> isProfitable = (c) -> {
        return c.getSuggestedPrice() > totalOutcome;
    };

    private IAction<Programmer> action = p -> p.doAction();

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
//                    for (Programmer programmer :
//                            programmers) {
//                        programmer.doAction();
//                    }
                    programmers.stream().forEach(p -> action.doAction(p));
                    entry.setValue(ProjectState.READY);
                    
                    this.apps.addApp(new App(entry.getKey().getProjectName()));
                    result += manager.getProfitFromClient(entry.getKey());
                }
            }
        }
        this.director.doAction();
        return result;
    }

    //gets list of profitable clients
    public List<Client> getProfitableClients() {
        return clients.stream()
                .filter(c -> c.getSuggestedPrice() > totalOutcome)
                .collect(Collectors.toList());
    }

    //gets list of all distinct used technologies
    public List<String> getUsedTechnologies() {
        return programmers.stream()
                .map(c -> c.getUsedTechnology())
                .distinct().collect(Collectors.toList());
    }

    //gets value of the minimum project income in programmers
    public int getCheapest() {
        return programmers.stream()
                .map(c -> c.getProjectIncome())
                .min(Integer::compare).get();
    }

    //Gets list of prices of clients' suggestions
    public List<Integer> getPrices() {
        return clients.stream()
                .map(c -> c.getSuggestedPrice())
                .sorted().collect(Collectors.toList());
    }
}
