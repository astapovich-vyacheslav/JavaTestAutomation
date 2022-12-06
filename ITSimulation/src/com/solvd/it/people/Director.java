package com.solvd.it.people;

import com.solvd.it.economy.reports.ProfitReport;
import com.solvd.it.economy.reports.Report;

import java.util.ArrayList;
import java.util.Date;

public final class Director extends Worker {
    private ArrayList<ProfitReport> profitReports = new ArrayList<>();

    public void addProfitReport(ProfitReport profitReport) {
        this.profitReports.add(profitReport);
        try {
            this.getIncome(profitReport.getProjectProfit());
        } catch (ENegativeIncome ignored) {

        }
    }

    public void removeProfitReport(ProfitReport profitReport) {
        this.profitReports.remove(profitReport);
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
            try {
                this.getIncome(profitReport.getProjectProfit());
            } catch (ENegativeIncome ignored) {

            }
        }
    }

    public Director(String name, Date dateOfBirth, int id, int projectIncome) {
        super(name, dateOfBirth, id, projectIncome);
    }

    public Director(Worker worker) {
        super(worker.getName(), worker.getDateOfBirth(), worker.getId(), worker.getProjectIncome());
    }

    public int giveSalary(Worker worker, int salary) {
        try {
            worker.getIncome(salary);
        } catch (ENegativeIncome ignored) {

        }
        return worker.getTotalIncome();
    }

    public int getIncome(int income, ProfitReport report) {
        this.setTotalIncome(this.getTotalIncome() + income + report.getProjectProfit());
        return this.getTotalIncome();
    }

    @Override
    public boolean doAction() {
        System.out.println("Director is working");
        return true;
    }
}
