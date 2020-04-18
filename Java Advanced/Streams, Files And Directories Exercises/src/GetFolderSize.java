import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetFolderSize {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\ste4o\\Desktop\\Exercises Resources";
        File file = new File(filePath);

        String pathOut = System.getProperty("user.dir") + "/resources/output.txt";
        try (PrintWriter writer = new PrintWriter(pathOut)) {
            if (file.isDirectory()) {
                long fileLength = file.length();
                String result = String.format("Folder size: %d", fileLength);
                writer.print(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
