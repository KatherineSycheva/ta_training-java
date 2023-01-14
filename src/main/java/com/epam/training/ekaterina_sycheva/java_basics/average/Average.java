package com.epam.training.ekaterina_sycheva.java_basics.average;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Use Scanner methods to read input
        int sum = 0;
        int i = 0;
        int next_val;
        next_val = scanner.nextInt();
        while (next_val != 0) {
            sum += next_val;
            i++;
            next_val = scanner.nextInt();
        }
        System.out.println(sum / i);

    }

}

