import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumBytes {

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String pathIn = "C:\\Users\\ste4o\\Desktop\\input.txt";
        String pathOut = userDir + "/resources/output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
             PrintWriter writer = new PrintWriter(pathOut);) {

            String inputLine = reader.readLine();
            int sum = 0;
            while (inputLine != null) {
                char[] currentLineSymbols = inputLine.toCharArray();
                for (char symbol : currentLineSymbols) {
                    sum += symbol;
                }
                inputLine = reader.readLine();
            }

            writer.print(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
