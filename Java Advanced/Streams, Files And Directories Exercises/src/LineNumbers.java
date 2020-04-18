import java.io.*;

public class LineNumbers {

    public static void main(String[] args) {

        String path = "C:\\Users\\ste4o\\Desktop\\inputLineNumbers.txt";
        String userDir = System.getProperty("user.dir");
        String pathOut = userDir + "/resources/output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathOut)));) {

            String inputLine = reader.readLine();
            int count = 1;
            while (inputLine != null){
                writer.write(String.valueOf(count) + ". ");
                writer.write(inputLine);
                writer.newLine();

                count++;
                inputLine = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
