import java.math.BigInteger;
import java.util.Scanner;
public class SumBigNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger firstNumber = new BigInteger(sc.nextLine());
        BigInteger secondNumber = new BigInteger(sc.nextLine());

        BigInteger sum = sumNumbers(firstNumber, secondNumber);
        printSum(sum);
    }

    static BigInteger sumNumbers(BigInteger firstNumber, BigInteger secondNumber){
        return firstNumber.add(secondNumber);
    }

    static void printSum(BigInteger sum){
        System.out.println(sum);
    }
}
