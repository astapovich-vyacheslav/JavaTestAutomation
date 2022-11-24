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

    public ProfitReport generateProfitReport(Client client) {
        int profit = this.clientsMap.get(client).getProfit();
        return new ProfitReport(profit, client.getProjectName());
    }

    @Override
    boolean work() {
        System.out.println("Manager is working");
        return true;
    }
}
