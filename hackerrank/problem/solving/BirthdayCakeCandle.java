package hackerrank.problem.solving;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BirthdayCakeCandle {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i : candles) {
            if (integerIntegerHashMap.containsKey(i)) {
                integerIntegerHashMap.put(i, integerIntegerHashMap.get(i) + 1);
            } else
                integerIntegerHashMap.put(i, 1);
        }
        List<Integer> collect = integerIntegerHashMap.values().stream().collect(Collectors.toList());
        return Collections.max(collect);

    }

}


