package hackerrank.mathematics;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/*
Consider two points, and . We consider the inversion or point reflection, , of point across point to be a rotation of point around

.

Given
sets of points and , find for each pair of points and print two space-separated integers denoting the respective values of and

on a new line.

Function Description

Complete the findPoint function in the editor below.

findPoint has the following parameters:

    int px, py, qx, qy: x and y coordinates for points

and

Returns

    int[2]: x and y coordinates of the reflected point

Input Format

The first line contains an integer,
, denoting the number of sets of points.
Each of the subsequent lines contains four space-separated integers that describe the respective values of , , , and defining points and

.

Constraints

Sample Input

2
0 0 1 1
1 1 2 2

Sample Output

2 2
3 3

Explanation

The graphs below depict points
, , and for the

points given as Sample Input:

    find-point-0011.png

    find-point-1122.png

 */
class Result {

    /*
     * Complete the 'findPoint' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER px
     *  2. INTEGER py
     *  3. INTEGER qx
     *  4. INTEGER qy
     */

    public static List<Integer> findPoint(int px, int py, int qx, int qy) {
        int rx = (2 * qx) - px;
        int ry = (2 * qy) - py;
        return Arrays.asList(rx, ry);

    }

}

public class FindThePoint {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src/main/resources/draft-file.txt")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        for (int nItr = 0; nItr < n; nItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int px = Integer.parseInt(firstMultipleInput[0]);

            int py = Integer.parseInt(firstMultipleInput[1]);

            int qx = Integer.parseInt(firstMultipleInput[2]);

            int qy = Integer.parseInt(firstMultipleInput[3]);

            List<Integer> result = Result.findPoint(px, py, qx, qy);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

