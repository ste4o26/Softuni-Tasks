import java.util.Scanner;

public class ExtractFiles {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();
        int indexOfFile = filePath.lastIndexOf("\\") + 1;
        String fileName = filePath.substring(indexOfFile, filePath.indexOf('.'));
        String fileExtension = filePath.substring(filePath.indexOf('.') + 1);
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileExtension);
    }
}
