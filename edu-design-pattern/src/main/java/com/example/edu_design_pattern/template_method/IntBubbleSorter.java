package com.example.edu_design_pattern.template_method;

public class IntBubbleSorter implements BubbleSorter<Integer>{
    @Override
    public boolean isOutOfOrder(Integer[] list, int index) {
        return list[index] > list[index+1];
    }

    @Override
    public void swap(Integer[] list, int index) {
        int tmp = list[index];
        list[index] = list[index+1];
        list[index+1] = tmp;
    }
}
