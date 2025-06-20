package hackerrank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class ResultPlusMinus {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        for(int i : arr){
            if(i > 0) positiveCount ++;
            else if(i < 0) negativeCount ++;
            else zeroCount ++;
        }
        System.out.println(new BigDecimal(positiveCount).divide(new BigDecimal(arr.size()), 6, BigDecimal.ROUND_HALF_UP));
        System.out.println(new BigDecimal(negativeCount).divide(new BigDecimal(arr.size()), 6, BigDecimal.ROUND_HALF_UP));
        System.out.println(new BigDecimal(zeroCount).divide(new BigDecimal(arr.size()), 6, BigDecimal.ROUND_HALF_UP));
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        ResultPlusMinus.plusMinus(arr);

        bufferedReader.close();
    }
}
