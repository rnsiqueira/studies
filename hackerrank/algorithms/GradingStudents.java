package hackerrank.algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultGradingStudents {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        ArrayList<Integer> roundGrades = new ArrayList<>();

        grades.forEach(g -> {
            if (g < 38) roundGrades.add(g);
            else if (Integer.valueOf(String.valueOf(g.toString().charAt(1))) == 3) roundGrades.add(g + 2);
            else if (Integer.valueOf(String.valueOf(g.toString().charAt(1))) == 4) roundGrades.add(g + 1);
            else {
                if (Arrays.asList(8, 9).contains(Integer.valueOf(String.valueOf(g.toString().charAt(1))))) {
                    roundGrades.add(Integer.valueOf(String.valueOf(Math.ceil(Double.valueOf(g.toString().charAt(0) + "." + g.toString().charAt(1)))).replace(".", "")));
                } else roundGrades.add(g);
            }
        });

        return roundGrades;

    }

}

public class GradingStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/files/draft.txt"));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = ResultGradingStudents.gradingStudents(grades);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
