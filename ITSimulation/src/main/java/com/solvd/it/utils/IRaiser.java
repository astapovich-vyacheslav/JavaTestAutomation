package com.solvd.it.utils;

@FunctionalInterface
public interface IRaiser<N, T, R> {
    N raise(T whoToRaise, R valueToRaise);
}
