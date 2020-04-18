import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCount {

    public static void main(String[] args) {

        String firstUrl = "C:\\Users\\ste4o\\Desktop\\words.txt";
        String secondUrl = "C:\\Users\\ste4o\\Desktop\\text.txt";
        Path firstPath = Paths.get(firstUrl);
        Path secondPath = Paths.get(secondUrl);
        String pathOut = System.getProperty("user.dir") + "/resources/output.txt";

        try (PrintWriter writer = new PrintWriter(pathOut)) {
            List<String> firstListOfLines = Files.readAllLines(firstPath);
            List<String> secondListOfLines = Files.readAllLines(secondPath);

            List<String> firstListOfWords = Arrays.stream(firstListOfLines.get(0).split("\\s+"))
                    .collect(Collectors.toList());

            Map<String, Integer> wordCount = new LinkedHashMap<>();
            for (String word : firstListOfWords) {
                wordCount.putIfAbsent(word, 0);
            }

            List<String> secondListOfWords = Arrays.stream(secondListOfLines.get(0).split("\\s+"))
                    .collect(Collectors.toList());

            for (String word : secondListOfWords) {
                if (wordCount.containsKey(word)) {
                    int newCount = wordCount.get(word) + 1;
                    wordCount.put(word, newCount);
                }
            }

            wordCount.forEach((k, v) -> writer.println(String.format("%s - %d", k, v)));
           // wordCount.forEach((k, v) -> System.out.printf("%s - %d%n", k, v));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
