package hackerrank.java;

import java.math.BigInteger;
import java.util.Scanner;

/*
In this problem, you have to add and multiply huge numbers! These numbers are so big that you can't contain them in any ordinary data types like a long integer.

Use the power of Java's BigInteger class and solve this problem.

Input Format

There will be two lines containing two numbers,
and

.

Constraints

and are non-negative integers and can have maximum

digits.

Output Format

Output two lines. The first line should contain
, and the second line should contain

. Don't print any leading zeros.

Sample Input

1234
20

Sample Output

1254
24680

 */
public class BigIntegerTest {

    public static void main(String[] args) {
        Scanner s = new Scanner("1234\n" +
                "20");

        BigInteger bi = new BigInteger(s.next());
        BigInteger bi1 = new BigInteger(s.next());

        System.out.println(bi.add(bi1) + "\n" + bi.multiply(bi1));
    }
}
