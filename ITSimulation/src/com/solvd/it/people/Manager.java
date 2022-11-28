package com.solvd.it.people;

import com.solvd.it.economy.IncomeAnalyzer;
import com.solvd.it.economy.reports.ProfitReport;

import java.util.*;

public class Manager extends Worker {
    private Dictionary<Client, IncomeAnalyzer> clientsMap;
    private int totalOutcome;

    public int getTotalOutcome() {
        return totalOutcome;
    }

    public void setTotalOutcome(int totalOutcome) {
        this.totalOutcome = totalOutcome;
    }

    public void addClient(Client client) {
        this.clientsMap.put(client, new IncomeAnalyzer(client, this.totalOutcome));
    }

    public void removeClient(Client client) {
        this.clientsMap.remove(client);
    }

    public Manager(String name, Date dateOfBirth, int id, int projectIncome, int totalOutcome, ArrayList<Client> clients) {
        super(name, dateOfBirth, id, projectIncome);
        this.clientsMap = new Hashtable<>();
        this.totalOutcome = totalOutcome;
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
        int profit = this.clientsMap.get(client).getProfit();
        return new ProfitReport(profit, client.getProjectName());
    }

    public int getProfitFromClient(Client client) {
        return this.clientsMap.get(client).getProfit();
    }

    @Override
    public boolean doAction() {
        System.out.println(this.getName() + " is working");
        return true;
    }

    public boolean refreshClientMap(ArrayList<Client> clients) {
        try {
            for (Client client :
                    clients) {
                this.clientsMap.put(client, new IncomeAnalyzer(client, totalOutcome));
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean checkProfitability(Client client) {
        return clientsMap.get(client).isProfitable();
    }
}
