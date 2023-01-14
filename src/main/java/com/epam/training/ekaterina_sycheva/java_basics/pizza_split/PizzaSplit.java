package com.epam.training.ekaterina_sycheva.java_basics.pizza_split;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int people = console.nextInt();
        int pieces = console.nextInt();
        boolean isSplit = true;
        int i = 1;
        while (isSplit) {
            if (i * pieces % people == 0) {
                isSplit = false;
            } else {
                i++;
            }
        }
        System.out.println(i);
    }
}
