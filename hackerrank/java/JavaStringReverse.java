package hackerrank.java;
//A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.(Wikipedia)
//
//        Given a string
//
//        , print Yes if it is a palindrome, print No otherwise.
//
//        Constraints
//
//        will consist at most
//
//        lower case english letters.
//
//        Sample Input
//
//        madam
//
//        Sample Output
//
//        Yes

import java.util.Scanner;

public class JavaStringReverse {

    public static void main(String[] args) {

        Scanner sc = new Scanner("madam");
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */

        System.out.println(A.equals(new StringBuilder(A).reverse().toString()) ? "Yes" : "No");


    }
}