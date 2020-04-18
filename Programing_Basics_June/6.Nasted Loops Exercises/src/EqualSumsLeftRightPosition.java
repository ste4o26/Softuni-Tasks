import java.util.Scanner;

public class EqualSumsLeftRightPosition {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstNumber = Integer.parseInt(sc.nextLine());
        int secondNumber = Integer.parseInt(sc.nextLine());

        for (int number = firstNumber; number <= secondNumber; number++) {
            int firstPair = number / 1000;
            int lastPair = number % 100;
            int middleDigit = (number % 1000) / 100;//(number / 100) % 10;

            int firstDigitFirstPair = firstPair / 10;
            int secondDigitFirstPair = firstPair % 10;

            int firstDigitLastPair = lastPair / 10;
            int secondDigitLastPair = lastPair % 10;

            int firstPairSum = firstDigitFirstPair + secondDigitFirstPair;
            int secondPairSum = firstDigitLastPair + secondDigitLastPair;

            if (firstPairSum != secondPairSum) {
               if (firstPairSum < secondPairSum) {
                    firstPairSum += middleDigit;
                } else {
                    secondPairSum += middleDigit;
                }
            }

            if (firstPairSum == secondPairSum) {
                System.out.print(number + " ");

            }
        }
    }
}
