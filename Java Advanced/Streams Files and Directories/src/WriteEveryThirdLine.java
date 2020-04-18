import java.io.*;

public class WriteEveryThirdLine {

    public static void main(String[] args) throws IOException {

        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "/resources/input.txt";
        String pathOut = userDir + "/resources/output.txt";

        File inputFile = new File(pathIn);
        File outputFile = new File(pathOut);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile.getAbsolutePath()));
             PrintWriter printWriter = new PrintWriter(outputFile.getAbsolutePath());) {

            int count = 1;
            String oneLine = bufferedReader.readLine();
            while (oneLine != null) {
                if (count % 3 == 0) {
                    printWriter.println(oneLine);
                }
                count++;
                oneLine = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
