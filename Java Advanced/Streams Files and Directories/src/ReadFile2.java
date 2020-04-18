import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile2 {

    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String path = userDir + "/resources/input.txt";

        try (FileReader fileReader = new FileReader(path);){
            int oneByte = fileReader.read();
            while (oneByte != -1){
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
