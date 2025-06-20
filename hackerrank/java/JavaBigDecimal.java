package hackerrank.java;


//Java's BigDecimal class can handle arbitrary-precision signed decimal numbers. Let's test your knowledge of them!
//
//        Given an array,
//        , of real number strings, sort them in descending order — but wait, there's more! Each number must be printed in the exact same format as it was read from stdin, meaning that is printed as , and is printed as . If two numbers represent numerically equivalent values (e.g.,
//
//        ), then they must be listed in the same order as they were received as input).
//
//        Complete the code in the unlocked section of the editor below. You must rearrange array
//
//        's elements according to the instructions above.
//
//        Input Format
//
//        The first line consists of a single integer,
//        , denoting the number of integer strings.
//        Each line of the subsequent lines contains a real number denoting the value of
//
//        .
//
//        Constraints
//
//        Each has at most
//
//        digits.
//
//        Output Format
//
//        Locked stub code in the editor will print the contents of array
//
//        to stdout. You are only responsible for reordering the array's elements.
//
//        Sample Input
//
//        9
//        -100
//        50
//        0
//        56.6
//        90
//        0.12
//        .12
//        02.34
//        000.000


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class JavaBigDecimal {

    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner("9\n" +
                "-100\n" +
                "50\n" +
                "0\n" +
                "56.6\n" +
                "90\n" +
                "0.12\n" +
                ".12\n" +
                "02.34\n" +
                "000.000\n");
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        //Write your code here
        Arrays.sort(s, Collections.reverseOrder(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1 == null || o2 == null)
                    return 0;
                BigDecimal a = new BigDecimal(o1);
                BigDecimal b = new BigDecimal(o2);

                return a.compareTo(b);
            }
        }));
        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}
