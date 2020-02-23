import java.util.Arrays;
import java.util.Scanner;

public class CaesarCipher {
    //encryption

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String encryptedText = encrypt(input);
        System.out.println(encryptedText);
    }

    public static String encrypt(String input) {
        char[] tokens = input.toCharArray();
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] += 3;
        }
        String encryptedText = Arrays.toString(tokens);
        return String.valueOf(tokens);
    }
}
