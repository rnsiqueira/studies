package hackerrank.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

/*
n computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail).

Deque interfaces can be implemented using various types of collections such as LinkedList or ArrayDeque classes. For example, deque can be declared as:

Deque deque = new LinkedList<>();
or
Deque deque = new ArrayDeque<>();

You can find more details about Deque here.

In this problem, you are given
integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size

.

Note: Time limit is

second for this problem.

Input Format

The first line of input contains two integers
and : representing the total number of integers and the size of the subarray, respectively. The next line contains

space separated integers.

Constraints




The numbers in the array will range between

.

Output Format

Print the maximum number of unique integers among all possible contiguous subarrays of size

.

Sample Input

6 3
5 3 5 2 3 2

Sample Output

3

Explanation

In the sample testcase, there are 4 subarrays of contiguous numbers.

- Has

unique numbers.

- Has

unique numbers.

- Has

unique numbers.

- Has

unique numbers.

In these subarrays, there are
unique numbers, respectively. The maximum amount of unique numbers among all possible contiguous subarrays is .
 */
public class JavaDequeue {


    public static void main(String[] args) {
        Scanner in = new Scanner("6 3\n" +
                "5 3 5 2 3 2");
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int unique = Integer.MIN_VALUE;
        HashSet<Integer> subArrays = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            subArrays.add(num);

            if (deque.size() == m) {
                if (subArrays.size() > unique) {
                    unique = subArrays.size();
                }
                int first = (int) deque.remove();
                if (!deque.contains(first)) {
                    subArrays.remove(first);

                }


            }

        }

        System.out.println(unique);
    }
}
