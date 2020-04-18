import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        Path pathIn = Paths.get(userDir + "/resources/input.txt");
        Path pathOut = Paths.get(userDir + "/resources/output.txt");

        try {
            List<String> linesOfFile = Files.readAllLines(pathIn)
                    .stream()
                    .filter(s -> !s.isEmpty())
                    .sorted(String::compareTo)
                    .collect(Collectors.toList());

            Files.write(pathOut, linesOfFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
