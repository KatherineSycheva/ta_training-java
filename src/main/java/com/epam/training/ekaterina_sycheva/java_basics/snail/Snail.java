package com.epam.training.ekaterina_sycheva.java_basics.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        int a, b, h;

        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        h = sc.nextInt();

        if (h - a <= 0) {
            System.out.println(1);
        } else if (a - b <= 0) {
            System.out.println("Impossible");
        } else {
            System.out.println(1 + (h - a)/(a - b));
        }

    }
}

