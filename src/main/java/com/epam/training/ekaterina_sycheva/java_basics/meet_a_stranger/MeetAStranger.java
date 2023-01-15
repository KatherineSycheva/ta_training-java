package com.epam.training.ekaterina_sycheva.java_basics.meet_a_stranger;

import java.util.Scanner;
public class MeetAStranger {
    public static void main(String[] args) {
        //Write a program, which read a String from System.in and print "Hello, <input string>"
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        System.out.println("Hello, " + input);
    }
}
