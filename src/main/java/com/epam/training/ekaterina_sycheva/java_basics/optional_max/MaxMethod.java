package com.epam.training.ekaterina_sycheva.java_basics.optional_max;

import java.util.*;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        OptionalInt maxValue = OptionalInt.empty();
        if (values != null && values.length != 0) {
            int maxv = values[0];
            for (int e : values) {
                if (e > maxv) maxv = e;
            }
            maxValue = OptionalInt.of(maxv);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int [] a = {};
        max(a);
    }
}
