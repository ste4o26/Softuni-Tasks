import java.util.Scanner;
public class RecursiveFibonacci2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int fibonacciNumber = getFibonacciNumber(n);
        System.out.println(fibonacciNumber);
    }

    static int getFibonacciNumber(int n){
        if(n == 1){
            return 1;
        }else if (n == 0){
            return 0;
        }
        int fibonacciNumber = 0;
        fibonacciNumber = getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
        return fibonacciNumber;
    }
}
