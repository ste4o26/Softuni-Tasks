package pizza_calories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int factorial = getFactorialOfNumber(n);
        System.out.println(factorial);
    }

    private static int getFactorialOfNumber(int n) {
        //fact 5 -> 5 * 4 * 3 * 2 * 1 -> 120
        if(n == 1){
            return 1;
        }

        return getFactorialOfNumber(n - 1) * n;
    }

}
