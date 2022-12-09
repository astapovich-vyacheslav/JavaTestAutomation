package com.solvd.it.people;

import com.solvd.it.Company;
import com.solvd.it.economy.IncomeAnalyzer;
import com.solvd.it.economy.reports.ProfitReport;
import org.apache.log4j.Logger;

import java.util.*;

public final class Manager extends Worker {
    private static final Logger log = Logger.getLogger(Manager.class);
    private Dictionary<Client, IncomeAnalyzer> clientsMap;

    public void addClient(Client client) {
        this.clientsMap.put(client, new IncomeAnalyzer());
    }

    public void removeClient(Client client) {
        this.clientsMap.remove(client);
    }

    public Manager(String name, Date dateOfBirth, int id, int projectIncome, int totalOutcome, ArrayList<Client> clients) {
        super(name, dateOfBirth, id, projectIncome);
        this.clientsMap = new Hashtable<>();
        if (clients == null)
            return;
        for (Client client :
                clients) {
            this.clientsMap.put(client, new IncomeAnalyzer(client));
        }
    }

    public Manager(Worker worker) {
        super(worker.getName(), worker.getDateOfBirth(), worker.getId(), worker.getProjectIncome());
        this.clientsMap = new Hashtable<>();
    }

    public ProfitReport generateProfitReport(Client client) {
        int profit = this.clientsMap.get(client).getProfit(client, Company.totalOutcome);
        return new ProfitReport(profit, client.getProjectName());
    }

    public int getProfitFromClient(Client client) {
        return this.clientsMap.get(client).getProfit(client, Company.totalOutcome);
    }

    @Override
    public boolean doAction() {
        log.info(this.getName() + " is working");
        return true;
    }

    public boolean refreshClientMap(Iterable<Client> clients) {
        try {
            for (Client client :
                    clients) {
                this.clientsMap.put(client, new IncomeAnalyzer());
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean checkProfitability(Client client) {
        return clientsMap.get(client).isProfitable(client, Company.totalOutcome);
    }
}
