import java.util.Scanner;
import java.util.Arrays;
public class EncryptSortAndPrintArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfStringsToEncrypt = Integer.parseInt(sc.nextLine());

        String[] sequenceOfWords = new String[numberOfStringsToEncrypt];
        fillArray(sequenceOfWords, sc);

        int[] encryptedStrings = new int[sequenceOfWords.length];
        encryptStrings(sequenceOfWords, encryptedStrings);
        sortEncryptedStrings(encryptedStrings);
        printArray(encryptedStrings);

    }

    static void fillArray(String[] sequenceOfWords, Scanner sc){
        for (int i = 0; i < sequenceOfWords.length; i++) {
            sequenceOfWords[i] = sc.nextLine();
        }
    }

    static void encryptStrings(String[] stringSequence, int[] encryptedStrings){
        for (int i = 0; i < stringSequence.length; i++) {
            String currentString = stringSequence[i];
            int wordEncryptedSum = 0;
            wordEncryptedSum = findSumOfWord(currentString);
            encryptedStrings[i] = wordEncryptedSum;
        }
    }


    static int findSumOfWord(String currentWord){
        int sum = 0;
        for (int i = 0; i < currentWord.length(); i++) {
            char currentLetter = currentWord.charAt(i);
            if(currentLetter >= 'A' && currentLetter <= 'Z'){
                if(currentLetter == 'A' || currentLetter == 'E' || currentLetter == 'I' || currentLetter == 'O' || currentLetter == 'U'){
                    sum += currentLetter * currentWord.length();
                }else {
                    sum += currentLetter / currentWord.length();
                }

            }else {
                if(currentLetter == 'a' || currentLetter == 'e' || currentLetter == 'i' || currentLetter == 'o' || currentLetter == 'u'){
                    sum += currentLetter * currentWord.length();
                }else {
                    sum += currentLetter / currentWord.length();
                }
            }
        }
        return sum;
    }

    static void sortEncryptedStrings(int [] encryptedStrings){
        for (int i = 0; i < encryptedStrings.length - 1; i++) {
            for (int j = i; j < encryptedStrings.length; j++) {
                int currentSum = encryptedStrings[i];
                int nextSum = encryptedStrings[j];
                if(nextSum < currentSum){
                    int temp = encryptedStrings[i];
                    encryptedStrings[i] = encryptedStrings[j];
                    encryptedStrings[j] = temp;
                }
            }
        }
    }

    static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
