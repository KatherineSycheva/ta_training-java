package com.epam.training.ekaterina_sycheva.java_basics.electronic_watch;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Calendar;


public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        int hs = (seconds - (seconds % 3600)) / 3600;
        int minis = ((seconds % 3600) - (seconds % 3600 % 60)) / 60;
        int secs = seconds % 3600 % 60;

        Calendar calendar = new GregorianCalendar();
        DateFormat df = new SimpleDateFormat("H:mm:ss");
        calendar.set(Calendar.HOUR_OF_DAY, hs);
        calendar.set(Calendar.MINUTE, minis);
        calendar.set(Calendar.SECOND, secs);
        System.out.println(df.format(calendar.getTime()));

    }
}
