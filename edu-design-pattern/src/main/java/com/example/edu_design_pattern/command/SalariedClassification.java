package com.example.edu_design_pattern.command;

public class SalariedClassification implements PayClassification{
    private final int monthlyPay;

    public SalariedClassification(int monthlyPay) {
        this.monthlyPay = monthlyPay;
    }

    @Override
    public int calculatePay() {
        return this.monthlyPay;
    }
}
