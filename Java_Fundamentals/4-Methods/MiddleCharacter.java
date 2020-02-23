import java.util.Scanner;

public class MiddleCharacter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        printMiddleCharacter(input);
    }

    static void printMiddleCharacter(String input) {
        if (input.length() % 2 == 0) {
            int leftMiddleCharacterPosition = (input.length() / 2) - 1;
            int rightMiddleCharacterPosition = input.length() / 2;

            System.out.printf("%c%c", input.charAt(leftMiddleCharacterPosition), input.charAt(rightMiddleCharacterPosition));

            //0s 1t 2e 3f 4a 5n
        } else {
            int middleCharacterPosition = input.length() / 2;
            System.out.printf("%c", input.charAt(middleCharacterPosition));
        }
    }
}
