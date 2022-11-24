package com.solvd.it.people;

import com.solvd.it.economy.reports.ProfitReport;
import com.solvd.it.economy.reports.Report;

import java.util.ArrayList;
import java.util.Date;

public class Director extends Worker {
    private ArrayList<ProfitReport> profitReports = new ArrayList<>();

    public void addProfitReport(ProfitReport profitReport) {
        this.profitReports.add(profitReport);
        this.getIncome(profitReport.getProjectProfit());
    }

    public void removeProfitReport(ProfitReport profitReport) {
        this.profitReports.remove(profitReport);
        this.getIncome(-profitReport.getProjectProfit());
    }

    public ArrayList<ProfitReport> getProfitReports() {
        return profitReports;
    }

    public Director(String name, Date dateOfBirth, int id, int projectIncome, ArrayList<ProfitReport> profitReports) {
        super(name, dateOfBirth, id, projectIncome);
        if (profitReports == null)
            return;
        this.profitReports = profitReports;
        for (ProfitReport profitReport :
                profitReports) {
            this.getIncome(profitReport.getProjectProfit());
        }
    }

    public Director(String name, Date dateOfBirth, int id, int projectIncome) {
        super(name, dateOfBirth, id, projectIncome);
    }

    public int giveSalary(Worker worker, int salary) {
        worker.getIncome(salary);
        return worker.getTotalIncome();
    }
    
    public int getIncome(int income, ProfitReport report) {
        this.setTotalIncome(this.getTotalIncome() + income + report.getProjectProfit());
        return this.getTotalIncome();
    }

    @Override
    boolean work() {
        System.out.println("Director is working");
        return true;
    }
}
