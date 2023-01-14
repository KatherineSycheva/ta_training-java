package com.epam.training.ekaterina_sycheva.java_basics.max_method;


public class MaxMethod {
    public static int max(int[] values) {
        int max_val = values[0];
        for (int val : values) {
            if (val > max_val) {
                max_val = val;
            }
        }
        return max_val;
    }
}
