import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {

        String mainDir = System.getProperty("user.dir");
        String path = mainDir + "/resources/input.txt";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            int oneByte = fileInputStream.read();
            while (oneByte != -1){
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fileInputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
