import java.util.Scanner;

public class LettersChangeNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split("\\s+");
        double totalSum = 0;
        for (int i = 0; i < tokens.length; i++) {
            double firstLetterResult = 0;
            double result = 0;
            int currentNumberBetweenLetters = Integer.parseInt(tokens[i].substring(1, tokens[i].length() - 1));

            char firstLetter = tokens[i].charAt(0);
            if(Character.isUpperCase(firstLetter)){
                firstLetterResult = (currentNumberBetweenLetters * 1.0) / (firstLetter - 64);
            }else {
                firstLetterResult = currentNumberBetweenLetters * (firstLetter - 96);
            }

            char lastLetter = tokens[i].charAt(tokens[i].length() - 1);
            if(Character.isUpperCase(lastLetter)){
                result = firstLetterResult - (lastLetter - 64);
            }else {
                result = firstLetterResult + (lastLetter - 96);
            }

            totalSum += result;
        }

        System.out.printf("%.2f", totalSum);
    }
}
