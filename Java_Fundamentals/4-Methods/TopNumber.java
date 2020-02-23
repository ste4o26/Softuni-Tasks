import java.util.Scanner;

public class TopNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int endingNumber = Integer.parseInt(sc.nextLine());
        printTopNumbers(endingNumber);
    }

    static void printTopNumbers(int endingNumber) {

        for (int currentNumber = 1; currentNumber <= endingNumber; currentNumber++) {
            boolean isDivisible = isSumDevisibleBy8(currentNumber);
            boolean hasOddDigit = hasOneOddDigit(currentNumber);

            if (isDivisible && hasOddDigit) {
                int topNumber = currentNumber;
                System.out.println(topNumber);
            }
        }
    }

    static boolean isSumDevisibleBy8(int number) {
        int sumOfDigits = 0;
        if (number / 10 == 0) {
            sumOfDigits = number;

        } else {
            int digitsLength = String.valueOf(number).length();
            //the easiest way to find the length of a particular int variable

            for (int i = 0; i < digitsLength; i++) {
                int currentDigit = number % 10;
                number = number / 10;

                sumOfDigits += currentDigit;
            }
        }
        if (sumOfDigits % 8 == 0) {
            return true;
        } else {
            return false;
        }
    }

    static boolean hasOneOddDigit(int number) {
        int digitsLength = String.valueOf(number).length();

        for (int i = 0; i < digitsLength; i++) {
            int currentDigit = number % 10;
            number /= 10;

            if (currentDigit % 2 == 0) {

            }else {
                return true;
            }
        }
        return false;
    }

}
