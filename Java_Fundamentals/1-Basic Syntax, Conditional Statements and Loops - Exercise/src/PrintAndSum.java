import java.util.Scanner;
public class PrintAndSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int startingNumber = Integer.parseInt(sc.nextLine());
        int endingNumber = Integer.parseInt(sc.nextLine());
        int sumOfAllNumbers = 0;

        for (int currentNumber = startingNumber; currentNumber <= endingNumber; currentNumber++) {
            sumOfAllNumbers += currentNumber;
            System.out.print(currentNumber + " ");
        }

        System.out.printf("%nSum: %d", sumOfAllNumbers);
    }
}
