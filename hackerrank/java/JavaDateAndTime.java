package hackerrank.java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class JavaDateAndTime {


    static Scanner scan = new Scanner("08 05 2015");

    static int month = scan.nextInt();
    static int day = scan.nextInt();
    static int year = scan.nextInt();

    public static String findDay(int month, int day, int year) {
        SimpleDateFormat format = new SimpleDateFormat("EEEEEE");


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.YEAR, year);


        return format.format(calendar.getTime()).toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(findDay(month, day, year));
    }

}
