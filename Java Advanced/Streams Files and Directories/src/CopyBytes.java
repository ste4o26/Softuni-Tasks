import java.io.*;

public class CopyBytes {

    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "/resources/input.txt";
        String pathOut = userDir + "/resources/output.txt";

        FileInputStream fileInputStream = null;
        FileWriter fileWriter = null;

        try {
            fileInputStream = new FileInputStream(pathIn);
            fileWriter = new FileWriter(pathOut);

            int oneByte = fileInputStream.read();
            while (oneByte > -1) {
                if (oneByte == 32 || oneByte == 10) {
                    fileWriter.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        int currentDigit = digits.charAt(i);
                        fileWriter.write(currentDigit);
                    }
                }

                oneByte = fileInputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null && fileWriter != null) {
                    fileInputStream.close();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
