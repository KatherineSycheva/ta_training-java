package com.epam.training.ekaterina_sycheva.java_basics.meet_an_agent;

import java.util.Scanner;

public class MeetAnAgent {
    final static int PASSWORD = 133976; //You can change pass, but don't change the type

    public static void main(String[] args) {
        //put you code here
        //System.out.println("Input number: ");
        Scanner inp = new Scanner(System.in);
        int input_number = inp.nextInt();

        if (input_number == PASSWORD) {
            System.out.println("Hello, Agent");
        } else {
            System.out.println("Access denied");
        }

    }
}
