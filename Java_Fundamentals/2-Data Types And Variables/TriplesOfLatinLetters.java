import java.util.Scanner;
public class TriplesOfLatinLetters {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfLetters = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numberOfLetters; i++) {
            for (int j = 0; j < numberOfLetters; j++) {
                for (int k = 0; k < numberOfLetters; k++) {
                    int firstLetter = 'a' + i;
                    int secondLetter = 'a' + j;
                    int thirdLetter = 'a' + k;

                    System.out.printf("%c%c%c%n",firstLetter, secondLetter, thirdLetter);
                }
            }
        }
    }
}
