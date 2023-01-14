package com.epam.training.ekaterina_sycheva.java_basics.meet_strangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        //Write a program, asks for a number - amount of strangers to meet.
        //Then reads stranger names line by line and prints line by line "Hello, ...".
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else if (num < 0) {
            System.out.println("Seriously? Why so negative?");
        }
        else {
            for (int i = 0; i < num; i++){
                String name = sc1.nextLine();
                System.out.println("Hello, " + name);
            }
        }

    }
}


