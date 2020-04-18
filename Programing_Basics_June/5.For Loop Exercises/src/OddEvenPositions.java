import java.util.Scanner;

public class OddEvenPositions {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double maxEvenPositionedNumber = Double.NEGATIVE_INFINITY;
        double minEvenPositionedNumber = Double.POSITIVE_INFINITY;
        double evenSum = 0.0;

        double maxOddPositionedNumber = Double.NEGATIVE_INFINITY;
        double minOddPositionedNumber = Double.POSITIVE_INFINITY;
        double oddSum = 0.0;

        for (int counter = 1; counter <= n; counter++) {
            double number = Double.parseDouble(scanner.nextLine());

            if (counter % 2 == 0) {
                if (number > maxEvenPositionedNumber) {
                    maxEvenPositionedNumber = number;
                }
                if (number < minEvenPositionedNumber) {
                    minEvenPositionedNumber = number;
                }

                evenSum += number;

            } else {
                if (number > maxOddPositionedNumber) {
                    maxOddPositionedNumber = number;
                }
                if (number < minOddPositionedNumber) {
                    minOddPositionedNumber = number;
                }

                oddSum += number;

            }
        }

        if(maxEvenPositionedNumber == Double.NEGATIVE_INFINITY && maxOddPositionedNumber == Double.NEGATIVE_INFINITY){

            System.out.printf("OddSum=%.2f,%n",oddSum);
            System.out.println("OddMin=No,");
            System.out.println("OddMax=No,");
            System.out.printf("EvenSum=%.2f,%n",evenSum);
            System.out.println("EvenMin=No,");
            System.out.println("EvenMax=No");

        }else if (maxEvenPositionedNumber == Double.NEGATIVE_INFINITY) {

            System.out.printf("OddSum=%.2f,%n", oddSum);
            System.out.printf("OddMin=%.2f,%n", minOddPositionedNumber);
            System.out.printf("OddMax=%.2f,%n", maxOddPositionedNumber);
            System.out.printf("EvenSum=%.2f,%n", evenSum);
            System.out.println("EvenMin=No,");
            System.out.println("EvenMax=No");

        } else if (maxOddPositionedNumber == Double.NEGATIVE_INFINITY) {

            System.out.printf("OddSum=%.2f,%n", oddSum);
            System.out.println("OddMin=No,");
            System.out.println("OddMax=No,");
            System.out.printf("EvenSum=%.2f,%n", evenSum);
            System.out.printf("EvenMin=%.2f,%n", minEvenPositionedNumber);
            System.out.printf("EvenMax=%.2f%n", maxEvenPositionedNumber);

        }else{
            System.out.printf("OddSum=%.2f,%n", oddSum);
            System.out.printf("OddMin=%.2f,%n", minOddPositionedNumber);
            System.out.printf("OddMax=%.2f,%n", maxOddPositionedNumber);
            System.out.printf("EvenSum=%.2f,%n", evenSum);
            System.out.printf("EvenMin=%.2f,%n", minEvenPositionedNumber);
            System.out.printf("EvenMax=%.2f%n", maxEvenPositionedNumber);
        }
    }
}
