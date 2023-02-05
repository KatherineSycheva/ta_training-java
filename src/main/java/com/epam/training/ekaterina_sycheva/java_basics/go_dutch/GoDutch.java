package com.epam.training.ekaterina_sycheva.java_basics.go_dutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int bill_sum = console.nextInt();
        int friends = console.nextInt();

        if (bill_sum < 0) {
            System.out.println("Bill total amount cannot be negative");
        } else if (friends <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        } else {
            int part = (int) ((bill_sum + bill_sum * 0.1) / friends);
            System.out.println(part);
        }
    }
}
