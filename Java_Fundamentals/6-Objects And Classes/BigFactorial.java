import java.math.BigInteger;
import java.util.Scanner;
public class BigFactorial {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberInRange = Integer.parseInt(sc.nextLine());
        BigInteger factorial = calculateFactorial(numberInRange);
        printFactorial(factorial);
    }

    static void printFactorial(BigInteger factorial) {
        System.out.println(factorial);
    }

    static BigInteger calculateFactorial(int numberInRange) {
        BigInteger factorial = new BigInteger("1");
        for (int i = 1; i <= numberInRange; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}
