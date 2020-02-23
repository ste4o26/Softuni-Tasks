import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BigInteger firstNumber = new BigInteger(sc.nextLine());
        BigInteger secondNumber = new BigInteger(sc.nextLine());

        if(secondNumber.equals(0)){
            System.out.println(0);
        }

        BigInteger result = firstNumber.multiply(secondNumber);
        System.out.println(result);
    }
}
