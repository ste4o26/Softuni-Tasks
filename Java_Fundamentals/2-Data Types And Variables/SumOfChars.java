import java.util.Scanner;
public class SumOfChars {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numberOfLetters = Integer.parseInt(sc.nextLine());
        int sumOfLetters = 0;

        for (int letterCounter = 1; letterCounter <= numberOfLetters; letterCounter++) {
            char currentLetter = sc.nextLine().charAt(0);
            sumOfLetters += currentLetter;
        }
        System.out.printf("The sum equals: %d", sumOfLetters);
    }
}
