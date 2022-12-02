package com.solvd.it.economy;

import com.solvd.it.people.Client;
import com.solvd.it.people.Worker;

import java.util.ArrayList;

public class IncomeAnalyzer {
    static ArrayList<Worker> workers;
    private int totalOutcome;
    private Client client;
    private int profit;

    public int getTotalOutcome() {
        return totalOutcome;
    }

    public void setTotalOutcome(int totalOutcome) {
        this.totalOutcome = totalOutcome;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public boolean addWorker(Worker worker) {
        try {
            workers.add(worker);
            this.totalOutcome += worker.getProjectIncome();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean removeWorker(Worker worker) {
        try {
            workers.remove(worker);
            this.totalOutcome -= worker.getProjectIncome();
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getProfit() {
        profit = client.getSuggestedPrice() - totalOutcome;
        return profit;
    }

    public int getProfit(Client client, int totalOutcome) {
        return client.getSuggestedPrice() - totalOutcome;
    }

    public IncomeAnalyzer(ArrayList<Worker> workersList, Client client) {
        IncomeAnalyzer.workers = workersList;
        this.client = client;

        int profit = client.getSuggestedPrice();
        for (Worker worker :
                workers) {
            this.totalOutcome += worker.getProjectIncome();
        }
        this.profit = profit - this.totalOutcome;
    }

    public IncomeAnalyzer(Client client, int totalOutcome) {
        this.client = client;
        this.totalOutcome = totalOutcome;
    }

    public IncomeAnalyzer(Client client) {
        this.client = client;
    }

    public IncomeAnalyzer(ArrayList<Worker> workersList) {
        IncomeAnalyzer.workers = workersList;
    }

    public IncomeAnalyzer() {

    }

    public boolean isProfitable() {
        return this.getProfit() > 0;
    }

    public boolean isProfitable(Client client, int totalOutcome) {
        return client.getSuggestedPrice() > totalOutcome;
    }
}
