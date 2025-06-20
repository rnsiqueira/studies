package hackerrank.java;

/*
A prime number is a natural number greater than whose only positive divisors are and itself. For example, the first six prime numbers are , , , , , and

.

Given a large integer,

, use the Java BigInteger class' isProbablePrime method to determine and print whether it's prime or not prime.

Input Format

A single line containing an integer,

(the number to be checked).

Constraints

contains at most

    digits.

Output Format

If

is a prime number, print prime; otherwise, print not prime.

Sample Input

13

Sample Output

prime

 */

import java.math.BigInteger;
import java.util.Scanner;

public class JavaPrimalityTest {

    private static final Scanner scanner = new Scanner("1");

//    private static final String validityPrimeNumber(String number){
//
//
//        return new BigInteger(number).isProbablePrime(Integer.parseInt(number)) ? "prime" : "not prime";
//    }

    public static void main(String[] args) {
        String n = scanner.nextLine();
        System.out.println(new BigInteger(n).isProbablePrime(100) ? "prime" : "not prime");

        scanner.close();
    }
}
