import java.util.Scanner;
public class SumNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int numberLength = input.length();
        int sumOfAllDigits = 0;

        for (int currentDigit = 0; currentDigit < numberLength; currentDigit++) {
            // best way of getting single character as numeric value from a string!!!
            sumOfAllDigits += Character.getNumericValue(input.charAt(currentDigit));
        }

        System.out.println(sumOfAllDigits);
    }
}
