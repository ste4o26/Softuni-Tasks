import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WriteFile {

    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "/resources/input.txt";
        String pathOut = userDir + "/resources/output.txt";
        Set<Character> symbols = new HashSet<>();
        fillSymbols(symbols);

        try (FileInputStream fileInputStream = new FileInputStream(pathIn);
                FileOutputStream fileOutputStream = new FileOutputStream(pathOut);){

            int oneByte = fileInputStream.read();
            while (oneByte != -1){
                char currentSymbol = (char)oneByte;
                if (!symbols.contains(currentSymbol)){
                    fileOutputStream.write(oneByte);
                }

                oneByte = fileInputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void fillSymbols(Set<Character> set){
        set.add(',');
        set.add('.');
        set.add('!');
        set.add('?');
    }
}
