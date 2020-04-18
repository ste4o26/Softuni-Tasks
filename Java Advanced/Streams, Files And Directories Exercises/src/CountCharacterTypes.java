import java.io.*;

public class CountCharacterTypes {

    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String pathIn = "C:\\Users\\ste4o\\Desktop\\input.txt";
        String pathOut = userDir + "/resources/output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathOut)));) {

            String inputLine = reader.readLine();
            int vowelsCounter = 0;
            int punctuationCounter = 0;
            int allSymbols = 0;

            while (inputLine != null) {
                char[] symbols = inputLine.toCharArray();
                for (char symbol : symbols) {
                    if (Character.isLowerCase(symbol) && isVowel(symbol)) {
                        vowelsCounter++;
                    } else if (isPunctuation(symbol)) {
                        punctuationCounter++;
                    } else {
                        if (symbol != ' ') {
                            allSymbols++;
                        }
                    }
                }

                inputLine = reader.readLine();
            }

            String result = String.format("Vowels: %d%n" +
                    "Consonants: %d%n" +
                    "Punctuation: %d%n", vowelsCounter, allSymbols, punctuationCounter);

            char[] output = result.toCharArray();
            writer.write(output, 0, output.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isVowel(char symbol) {
        return symbol == 'a'
                || symbol == 'e'
                || symbol == 'i'
                || symbol == 'o'
                || symbol == 'u';
    }

    private static boolean isPunctuation(char symbol) {
        return symbol == '!'
                || symbol == '?'
                || symbol == '.'
                || symbol == ',';
    }
}
