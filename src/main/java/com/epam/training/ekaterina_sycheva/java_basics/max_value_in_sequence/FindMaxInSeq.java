package com.epam.training.ekaterina_sycheva.java_basics.max_value_in_sequence;

import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        // Put your code here
        Scanner console = new Scanner(System.in);
        int next_val = console.nextInt();
        int max_val = next_val;
        while (next_val != 0){
            next_val = console.nextInt();
            if (max_val < next_val && next_val != 0) {
                max_val = next_val;
            }
        }
        return max_val;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
