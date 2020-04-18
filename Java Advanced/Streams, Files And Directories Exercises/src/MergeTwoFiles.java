import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MergeTwoFiles {

    public static void main(String[] args) {
        String firstUrl = "C:\\Users\\ste4o\\Desktop\\inputOne.txt";
        String secondUrl = "C:\\Users\\ste4o\\Desktop\\inputTwo.txt";
        Path firstPath = Paths.get(firstUrl);
        Path secondPath = Paths.get(secondUrl);
        String pathOut = System.getProperty("user.dir") + "/resources/output.txt";

        try (PrintWriter writer = new PrintWriter(pathOut)) {
            List<String> firstList = Files.readAllLines(firstPath);
            List<String> secondList = Files.readAllLines(secondPath);

            firstList.forEach(element -> writer.println(element));//tova e ekvivalent na dolnoto
            secondList.forEach(writer::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
