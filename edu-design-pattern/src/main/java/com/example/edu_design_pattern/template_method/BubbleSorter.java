package com.example.edu_design_pattern.template_method;

public interface BubbleSorter<E> {
    default void sort(E[] list){
        for (int i = list.length-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isOutOfOrder(list, j)) {
                    swap(list, j);
                }
            }
        }
    }
    boolean isOutOfOrder(E[] list, int index);
    void swap(E[] list, int index);
}
