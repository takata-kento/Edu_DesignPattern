package com.example.edu_design_pattern.command;

import java.util.Date;

public class TimeCard {
    private final Date date;
    private final int hours;

    public TimeCard(Date date, int hours) {
        this.date = date;
        this.hours = hours;
    }

    public Date getDate() {
        return this.date;
    }

    public int getHours() {
        return this.hours;
    }
}
