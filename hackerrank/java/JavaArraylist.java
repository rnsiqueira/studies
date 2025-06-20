package hackerrank.java;

import java.util.ArrayList;
import java.util.Scanner;

/*
Sometimes it's better to use dynamic size arrays. Java's Arraylist can provide you this feature. Try to solve this problem using Arraylist.

You are given
lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in position of

line.

Take your input from System.in.

Input Format
The first line has an integer
. In each of the next lines there will be an integer denoting number of integers on that line and then there will be space-separated integers. In the next line there will be an integer denoting number of queries. Each query will consist of two integers and

.

Constraints

Each number will fit in signed integer.
Total number of integers in lines will not cross

.

Output Format
In each line, output the number located in
position of

line. If there is no such position, just print "ERROR!"

Sample Input

5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5

Sample Output

74
52
37
ERROR!
ERROR!

 */
public class JavaArraylist {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner s = new Scanner("5\n" +
                "5 41 77 74 22 44\n" +
                "1 12\n" +
                "4 37 34 36 52\n" +
                "0\n" +
                "3 20 22 33\n" +
                "5\n" +
                "1 3\n" +
                "3 4\n" +
                "3 1\n" +
                "4 3\n" +
                "5 5");

        ArrayList<int[]> queries = new ArrayList<>();
        int n = s.nextInt();
        int countLines = 0;
        int totalLines = n;

        while (s.hasNext()) {
            if (countLines == totalLines)
                break;

            int line = s.nextInt();
            int[] numbers = new int[line];
            for (int i = 0; i < line; i++) {
                numbers[i] = s.nextInt();


            }
            queries.add(numbers);
            countLines++;
        }
        int totalQueries = s.nextInt();
        for (int i = 0; i < totalQueries; i++){
            int x = s.nextInt() -1;
            int y = s.nextInt() -1;

           try {
               System.out.println(queries.get(x)[y]);
           }
           catch (ArrayIndexOutOfBoundsException e){
               System.out.println("ERROR!");
           }
        }


    }
}
