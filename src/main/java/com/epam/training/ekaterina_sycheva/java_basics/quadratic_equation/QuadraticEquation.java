package com.epam.training.ekaterina_sycheva.java_basics.quadratic_equation;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double d = b * b - 4 * a * c;
        if (d < 0) {
            System.out.println("no roots");
        } else if (d == 0) {
            double x = (-1 * b) / (2 * a);
            System.out.println(x);
        } else {
            double x1 = (-1 * b + sqrt(d)) / (2 * a);
            double x2 = (-1 * b - sqrt(d)) / (2 * a);
            System.out.println(x1 + " " + x2);
        }



    }

}