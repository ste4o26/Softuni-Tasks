import java.util.Scanner;
public class IntegerOperation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstNumber = Integer.parseInt(sc.nextLine());
        int secondNumber =  Integer.parseInt(sc.nextLine());
        int thirdNumber = Integer.parseInt(sc.nextLine());
        int fourthNumber = Integer.parseInt(sc.nextLine());

        int totalSum;
        int firstTwoNumbersSum = firstNumber + secondNumber;
        totalSum = (firstTwoNumbersSum / thirdNumber) * fourthNumber;

        System.out.println(totalSum);
    }
}
