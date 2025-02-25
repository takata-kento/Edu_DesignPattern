package com.example.edu_design_pattern.command;

import java.util.List;

public class HourlyClassification implements PayClassification{
    private final int hourlyRate;
    private List<TimeCard> timeCards;

    public HourlyClassification(int hourlyRate, List<TimeCard> timeCards) {
        this.hourlyRate = hourlyRate;
        this.timeCards = timeCards;
    }

    @Override
    public int calculatePay() {
        return timeCards.stream().mapToInt(TimeCard::getHours).sum() * this.hourlyRate;
    }
}
