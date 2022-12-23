package com.solvd.it.utils;

@FunctionalInterface
public interface IIncomeGiver<W, T> {
    void giveIncome(W worker, T income);
}
