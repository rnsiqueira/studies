package java18;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Class shows portability issues when a file encoded in UTF-8(example macOS) is later
 * read using a different encoding,example : Windows OS with different encoding.
 */
public class CharsetDemoPortability {

    //Edit this path as required.
    private static final String SOURCE_FILE_PATH = "src/source.txt";
    private static final String DESTINATION_FILE_PATH= "destination.txt";

    public static void main(String[] args) {

        System.out.println("Default charset is : " + Charset.defaultCharset());

        //Read the contents from "source.txt" using FileReader
        var linesList = new ArrayList<String>();
        try (var reader = new BufferedReader(new FileReader(SOURCE_FILE_PATH))) {
            var line = "";
            while ((line = reader.readLine()) != null) {
                linesList.add(line);
            }
        } catch (IOException e) {
            System.out.println("IOException while reading =>" + e.getMessage());
        }
        //Append a victory sign at the end of every line.
        var victoryUnicode = '\u270c';

        //Write the contents to "destination.txt" using FileWriter
        try (var writer = new BufferedWriter(new FileWriter(DESTINATION_FILE_PATH))) {
            for (var line : linesList) {
                writer.write(line + victoryUnicode + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("IOException while writing =>" + e.getMessage());
        }
    }
}
