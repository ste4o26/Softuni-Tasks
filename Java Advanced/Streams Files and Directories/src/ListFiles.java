import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {

    public static void main(String[] args) {

        //String path = "D:\\SoftUni Exercises\\3-Advanced Module\\Java Advanced\\4-Streams, Files And Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources.zip\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        // putqt kum failovete ne moje da se otkrie i vrashta null s goriniq string
        String userDir = System.getProperty("user.dir");
        String path = userDir + "/resources";
        File directory = new File(path);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.printf("%s: [%d]%n", file.getName(), file.length());
                }
            }
        }
        //DFS(directory);

    }

    static void DFS(File root) {
        if (root == null) {
            return;
        }

        File[] files = root.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                DFS(file);
            } else {
                System.out.printf("%s, %d%n", file.getName(), file.length());
            }
        }
    }
}
