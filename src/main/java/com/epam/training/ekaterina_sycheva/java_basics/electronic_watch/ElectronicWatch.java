package com.epam.training.ekaterina_sycheva.java_basics.electronic_watch;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Calendar;


public class ElectronicWatch {
    /**
     *
     The program prints an electronic watch screen output for a given value of seconds since midnight.
     Input value is given via System.in. Output value prints to System.out
     It is guaranteed, that input number is non-negative.
     Output format is h:mm:ss (possible values: [0:00:00; 23:59:59]).
     * @param args
     */
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
