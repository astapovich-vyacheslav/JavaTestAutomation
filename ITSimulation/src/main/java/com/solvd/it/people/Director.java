package com.solvd.it.people;

import com.solvd.it.custom.exceptions.ENegativeIncome;
import com.solvd.it.economy.reports.ProfitReport;

import com.solvd.it.utils.IIncomeGiver;
import com.solvd.it.utils.IRaiser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.Function;

public final class Director extends Worker {
    private static final Logger log = LogManager.getLogger(Director.class);
    private ArrayList<ProfitReport> profitReports = new ArrayList<>();

    BiConsumer<Worker, Integer> giveMoney = (w, i) -> {
        try {
            w.getIncome(i);
        } catch (Exception ignored) {
        }
    };

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

    public Director(String name, int id, int projectIncome) {
        super(name, id, projectIncome);
    }

    public Director(Worker worker) {
        super(worker.getName(), worker.getDateOfBirth(), worker.getId(), worker.getProjectIncome());
    }

    public int giveSalary(Worker worker, int salary) {
        IIncomeGiver<Worker, Integer> incomeGiver = (w, t) -> {
            try {
                w.getIncome(t);
            } catch (ENegativeIncome ignored) {
            }
        };
        return worker.getTotalIncome();
    }

    public int raise(Worker worker, int raiseValue) {
        IRaiser<Integer, Worker, Integer> raiser = (w, r) -> {
            w.setProjectIncome(w.getProjectIncome() + r);
            return w.getProjectIncome();
        };
        return raiser.raise(worker, raiseValue);
    }

    public int getIncome(int income, ProfitReport report) {
        this.setTotalIncome(this.getTotalIncome() + income + report.getProjectProfit());
        return this.getTotalIncome();
    }

    @Override
    public boolean doAction() {
        log.info("Director is working");
        return true;
    }

    public int printReports() {
        profitReports.stream().forEach(r -> log.info(r.toString()));
        return profitReports.size();
    }
}
