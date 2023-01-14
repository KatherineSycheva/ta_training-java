package com.epam.training.ekaterina_sycheva.java_basics.sum_of_previous;

import java.util.Arrays;

public class SumOfPrevious {

    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 0, 4, 6, 10, 15, 25};

        System.out.println(Arrays.toString(getSumCheckArray(array)));
    }

    public static boolean[] getSumCheckArray(int[] array){

        //put your code here
        boolean[] res_array = new boolean[array.length];

        res_array[0] = false;
        res_array[1] = false;
        for (int i = 2; i < array.length; i++) {
            res_array[i] = array[i - 1] + array[i - 2] == array[i];
        }
        //throw new UnsupportedOperationException();
        return res_array;
    }
}
