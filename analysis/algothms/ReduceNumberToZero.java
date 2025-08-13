package analysis.algothms;

public class ReduceNumberToZero {

    public static int reduceNumberWithArithmetic(int number) {
        var steps = 0;
        while (number > 0) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number -= 1; // If odd, subtract 1
            }
            steps++;
        }
        return steps;
    }

    private static int reduceNumberWithBitMask(int number) {
        var steps = 0;
        if ((number & 1) == 0) {
            number >>= 1;
        } else {
            number -= 1; // If odd, subtract 1
        }
        steps++;

        return steps;
    }

    public static void main(String[] args) {
        System.out.println(reduceNumberWithArithmetic(57575)); // Example usage
        System.out.println(reduceNumberWithBitMask(57575)); // Example usage
    }


}
