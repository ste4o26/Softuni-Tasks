import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumLines {

    public static void main(String[] args) {
//
//        String userDir = System.getProperty("user.dir");
//        String path = userDir + "/resources/input.txt";

        String path = "C:\\Users\\ste4o\\Desktop\\input.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path));){
            String inputLine = reader.readLine();
            while (inputLine != null){
                int rowAsciiSum = 0;
                for (char symbol : inputLine.toCharArray()) {
                    rowAsciiSum += symbol;
                }
//                for (int i = 0; i < inputLine.length(); i++) {
//                    char currentSymbol = inputLine.charAt(i);
//                    rowAsciiSum += currentSymbol;
//                }
                System.out.println(rowAsciiSum);
                inputLine = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
