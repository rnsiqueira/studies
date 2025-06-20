package hackerrank.problem.solving;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Timer;

class ResultConverTime {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        SimpleDateFormat parseTime = new SimpleDateFormat("hh:mm:ssa");
        SimpleDateFormat resultTime = new SimpleDateFormat("HH:mm:ss");
        Date parseDate;
        try {
            parseDate = parseTime.parse(s);
        }catch (ParseException e) {
            return null;
        }
        return resultTime.format(parseDate);

    }

}

public class ConvertTime {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/draft-file.txt"));

        String s = bufferedReader.readLine();

        String result = ResultConverTime.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
