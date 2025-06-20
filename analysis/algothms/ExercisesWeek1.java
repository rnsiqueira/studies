package analysis.algothms;

/*
1.14 Follow through the steps given for quicksort to solve the recurrence:
∑
An = 1+2N∑1≤j≤N Aj−1 for N > 0

1.15 Show that the average number of exchanges used during the first partitioning stage (before the pointers cross) is
 (N−2)/6.

 (Thus, by linearity of the recurrences, the average number of exchanges used by quicksort is
 1/6Cn - 1/2An

 */

public class ExercisesWeek1 {

//    1.14
   public void exercise(Comparable[] A, int max) {
       for(int N = 1; N <= max; N++) {
            A[N] = 1+(2*N);
            for(int j = 0; j < N; j ++) {

            }
       }
   }


}
