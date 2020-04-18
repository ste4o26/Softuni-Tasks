import java.io.*;

public class ALLCAPITALS {

    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String pathIn = "C:\\Users\\ste4o\\Desktop\\input.txt";
        String pathOut = userDir + "/resources/output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathOut)));) { // po tozi nachin se implementira PrintWriter
            String inputLine = reader.readLine();
            while (inputLine != null) {

                char[] sequenceOfSymbols = inputLine.toCharArray();
                for (int i = 0; i < sequenceOfSymbols.length; i++) {
                    char symbol = sequenceOfSymbols[i];
                    if (Character.isLetter(symbol) && Character.isLowerCase(symbol)) {
                        sequenceOfSymbols[i] = Character.toUpperCase(symbol);
                    }
                }

                writer.write(sequenceOfSymbols, 0, sequenceOfSymbols.length);
                writer.newLine();

                inputLine = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
