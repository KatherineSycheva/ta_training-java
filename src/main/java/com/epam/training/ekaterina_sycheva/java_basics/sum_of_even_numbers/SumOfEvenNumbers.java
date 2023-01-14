package com.epam.training.ekaterina_sycheva.java_basics.sum_of_even_numbers;

public class SumOfEvenNumbers {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 8, 15, 199};

        System.out.println(sum(array));
    }

    public static int sum(int[] array){
        if (array == null) {
            return 0;
        } else {
            int sum_even = 0;
            for (int val : array) {
                if (val % 2 == 0) {
                    sum_even += val;
                }
            }
            return sum_even;
        }
    }
}
