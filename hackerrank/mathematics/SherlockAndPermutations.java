package hackerrank.mathematics;

/*
Watson asks Sherlock:
Given a string S of N 0's and M 1's, how many unique permutations of this string start with 1?

Help Sherlock by printing the answer modulo (109+7).

Input Format
First line contains T, the number of test cases.
Each test case consists of N and M separated by a space.

Output Format
For each test case, print the answer modulo (109+7).

Constraints
1 ≤ T ≤ 200
1 ≤ N,M ≤ 1000

Sample Input

2
1 1
2 3

Sample Output

1
6

Explanation
Test1: Out of all unique permutations ie. 01 and 10, only second permutation satisfies. Hence, output is 1.
Test2: Out of all unique permutations ie. 00111 01011 01101 01110 10011 10101 10110 11001 11010 11100, only 10011 10101 10110 11001 11010 11100 satisfy. Hence, output is 6.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SherlockAndPermutations {
    static int solve(int n, int m) {
        int equa = (fact(n + m - 1) / (fact(m - 1) * fact(n))) % 1000000007;

        return equa == 0 ? 1 : equa;

    }

    private static int fact(int valor) {
        if (valor == 0)
            return 1;


        int fat = valor;
        for (int i = valor; i > 1; i--) {
            fat *= i - 1;
        }

        return fat;
    }

    private static final Scanner scanner = new Scanner("2\n" +
            "1 1\n" +
            "2 3");

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src/resources/files/draft.txt")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");
            String truncated = "";
            if (nm[0].contains("{-truncated-}") || nm[1].contains("{-truncated-}")) {
                nm[0] = nm[0].substring(0, 1);
                nm[1] = nm[1].substring(0, 1);
                truncated = "{-truncated-}";
            }

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int result = solve(n, m);

            bufferedWriter.write(String.valueOf(result + truncated));
            System.out.println(String.valueOf(result + truncated));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

}
