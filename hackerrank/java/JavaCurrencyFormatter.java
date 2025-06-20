package hackerrank.java;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class JavaCurrencyFormatter {
    /* Given a double-precision number, , denoting an amount of money, use the NumberFormat class' getCurrencyInstance method to convert

into the US, Indian, Chinese, and French currency formats. Then print the formatted values as follows:

US: formattedPayment
India: formattedPayment
China: formattedPayment
France: formattedPayment
*/


    public static void main(String[] args) {

        Scanner scan = new Scanner("12324.134");

        String payment = scan.next();

        scan.close();

        Locale indiaLocale = new Locale("en", "IN");


        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat francaFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);


        System.out.println("US: " + usFormat.format(Double.valueOf(payment)));
        System.out.println("India: " + indiaFormat.format(Double.valueOf(payment)));
        System.out.println("China: " + chinaFormat.format(Double.valueOf(payment)));
        System.out.println("France: " + francaFormat.format(Double.valueOf(payment)));
    }
}
