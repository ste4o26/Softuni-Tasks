import java.util.Scanner;
public class DecryptingMessage {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int key = Integer.parseInt(sc.nextLine());
        int numberOfInputLines = Integer.parseInt(sc.nextLine());
        String decryptedMessage = "";

        for (int currentLine = 0; currentLine < numberOfInputLines; currentLine++) {
            char letter = sc.nextLine().charAt(0);
            letter += key;
            decryptedMessage = String.format("%s%c", decryptedMessage, letter);
        }
        System.out.println(decryptedMessage);
    }
}
