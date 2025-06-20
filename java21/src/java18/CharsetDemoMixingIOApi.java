package java18;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Example shows Mixing of IO APIs where one call(readAllLines) uses UTF-8 by default
 * and the other call is decided when runtime starts
 */
public class CharsetDemoMixingIOApi {

    //Edit this path as required.
    private static final String SOURCE_FILE_PATH = "src/source.txt";
    private static final String DESTINATION_FILE_PATH= "destination.txt";

    public static void main(String[] args) throws IOException {

        var victoryUnicode = '\u270c';

        var linesList = Files.readAllLines(Paths.get(SOURCE_FILE_PATH));

        try (var bufferedWriter = new BufferedWriter(new FileWriter(DESTINATION_FILE_PATH))) {
            for (var line : linesList) {
                bufferedWriter.write(line + victoryUnicode + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("IOException while writing =>" + e.getMessage());
        }
    }
}
