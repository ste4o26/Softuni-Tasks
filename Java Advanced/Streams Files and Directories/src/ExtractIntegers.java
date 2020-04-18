import javax.imageio.stream.FileImageOutputStream;
import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {

    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "/resources/input.txt";
        String pathOut = userDir + "/resources/output.txt";
        File inputFile = new File(pathIn);
        File outputFile = new File(pathOut);

        try (Scanner sc = new Scanner(new FileInputStream(inputFile.getAbsolutePath()));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputFile.getAbsolutePath()));) {

            while (sc.hasNext()) {
                if (sc.hasNextInt()){// check if next value is integer value
                    printWriter.println(sc.nextInt());// printing every int into a file on a new line
                }

                sc.next();// updating the variable inside the loop -> going to next symbol every time the loops end
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
