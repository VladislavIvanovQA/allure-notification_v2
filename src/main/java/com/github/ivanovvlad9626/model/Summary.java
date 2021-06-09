package com.github.ivanovvlad9626.model;

public class Summary {
    private final Statistic statistic;
    private final Time time;

    public Summary(Statistic statistic, Time time) {
        this.statistic = statistic;
        this.time = time;
    }

    public Statistic statistic() {
        return statistic;
    }

    public Time time() {
        return time;
    }
}
