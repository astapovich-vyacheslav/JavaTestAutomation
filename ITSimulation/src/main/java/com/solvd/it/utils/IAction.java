package com.solvd.it.utils;

@FunctionalInterface
public interface IAction<T> {
    boolean doAction(T person);
}
