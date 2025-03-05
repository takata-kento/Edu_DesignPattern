package com.example.edu_design_pattern.template_method;

public class DoubleBubbleSorter implements BubbleSorter<Double>{
    @Override
    public boolean isOutOfOrder(Double[] list, int index) {
        return list[index] > list[index+1];
    }

    @Override
    public void swap(Double[] list, int index) {
        double tmp = list[index];
        list[index] = list[index+1];
        list[index+1] = tmp;
    }
}
