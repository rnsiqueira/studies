package hackerrank.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
You are given a

2D array. An hourglass in an array is a portion shaped like this:

a b c
  d
e f g

For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following:

1 1 1     1 1 0     1 0 0
  1         0         0
1 1 1     1 1 0     1 0 0

The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.

In this problem you have to print the largest sum among all the hourglasses in the array.

Input Format

There will be exactly
lines, each containing integers seperated by spaces. Each integer will be between and

inclusive.

Output Format

Print the answer to this problem on a single line.

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0

Sample Output

19

Explanation

The hourglass which has the largest sum is:

2 4 4
  2
1 2 4

 */
public class Java2DArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();
        int[][] a = new int[6][6];
        int sum2D = Integer.MIN_VALUE;

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
                a[i][j] = arrItem;

               if(i > 1 && j > 1){
                   int sum = a[i][j]
                           + a[i][j-1]
                           + a[i][j-2]
                           + a[i-1][j-1]
                           + a[i-2][j]
                           + a[i-2][j-1]
                           + a[i-2][j-2];
                   if(sum > sum2D)
                       sum2D = sum;
               }




            }

            arr.add(arrRowItems);
        }

        bufferedReader.close();

        System.out.println(arr);
    }

}
