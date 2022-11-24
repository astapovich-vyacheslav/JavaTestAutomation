package com.solvd.it.economy.reports;

import java.util.Objects;

public class ProfitReport implements Report {
    private String projectName;
    private final int projectProfit;

    public int getProjectProfit() {
        return projectProfit;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public ProfitReport(int projectProfit, String projectName) {
        this.projectProfit = projectProfit;
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "ProfitReport{" +
                "projectName='" + projectName + '\'' +
                ", projectProfit=" + projectProfit +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, projectProfit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfitReport report = (ProfitReport) o;
        return projectProfit == report.projectProfit && projectName.equals(report.projectName);
    }

    @Override
    public String getReportInfo(int income) {
        String result = "Project's profit is " + income;
        System.out.println(result);
        return result;
    }
}
