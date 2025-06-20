package hackerrank.java;

import java.util.Scanner;

/*
he elements of a String are called characters. The number of characters in a String is
 called the length, and it can be retrieved with the String.length() method.

Given two strings of lowercase English letters,
and

, perform the following operations:

    Sum the lengths of

and
.
Determine if
is lexicographically larger than (i.e.: does come before
in the dictionary?).
Capitalize the first letter in
and and print them on a single line, separated by a space.

------------------
Sample Input 0

hello
java

Sample Output 0

9
No
Hello Java


 */
public class JavaStringsIntroduction {

    public static void main(String[] args) {

        Scanner scanner = new Scanner("hello\n" +
                "java");

        String a = scanner.next();
        String b = scanner.next();
        scanner.close();

        int sum = a.length() + b.length();


        System.out.println(sum + "\n" + lexicographically(a, b) + "\n"
                + a.replace(a.charAt(0), a.toUpperCase().charAt(0)) + " " + b.replace(b.charAt(0), b.toUpperCase().charAt(0)));

    }

    private static String lexicographically(String a, String b) {
        if (a.compareTo(b) > 0)
            return "Yes";

        return "No";

    }
}
