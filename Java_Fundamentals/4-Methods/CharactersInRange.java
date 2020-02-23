import java.util.Scanner;
public class CharactersInRange {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char startingLetter = sc.nextLine().charAt(0);
        char endingLetter = sc.nextLine().charAt(0);

        printCharactersInRange(startingLetter, endingLetter);
    }

    static void printCharactersInRange(char startingLetter, char endingLetter){
        char currentLetter;
        if(startingLetter > endingLetter){
            char temp = endingLetter;
            endingLetter = startingLetter;
            startingLetter = temp;

            printCharactersInRange(startingLetter, endingLetter);
        }else {
            for (int i = startingLetter + 1; i < endingLetter; i++) {
                currentLetter = (char) i;
                System.out.print(currentLetter + " ");
            }
        }
    }
}
