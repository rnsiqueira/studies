package hackerrank.java;

/*
Two strings, and

, are called anagrams if they contain all the same characters in the same frequencies. For example, the anagrams of CAT are CAT, ACT, TAC, TCA, ATC, and CTA.

Complete the function in the editor. If
and

are case-insensitive anagrams, print "Anagrams"; otherwise, print "Not Anagrams" instead.

Input Format

The first line contains a string denoting
.
The second line contains a string denoting

.

Constraints

Strings and

    consist of English alphabetic characters.
    The comparison should NOT be case sensitive.

Output Format

Print "Anagrams" if
and

are case-insensitive anagrams of each other; otherwise, print "Not Anagrams" instead.

Sample Input 0

anagram
margana

Sample Output 0

Anagrams


 */

import java.util.Scanner;

public class JavaAnagrams {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a == null || b == null || a.equals("") || b.equals(""))
            throw new IllegalArgumentException();

        if (a.length() != b.length())
            return false;

        a = a.toLowerCase();
        b = b.toLowerCase();

        int amount = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a.length(); i++) {
            sb.append(a.charAt(i));
            amount++;

        }

        for (int i = 0; i < b.length(); i++) {
            char letter = b.charAt(i);

            if (sb.toString().contains(String.valueOf(letter))) {
                int index = sb.indexOf(String.valueOf(letter));
                sb.deleteCharAt(index);
                amount--;

            }
        }
        return amount == 0;


    }

    public static void main(String[] args) {

        Scanner scan = new Scanner("Hello\n" +
                "hello");
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }

}
