import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int nthFibonacciNumber = getNthFibonacciNumber(n);
        System.out.println(nthFibonacciNumber);
    }

    private static int getNthFibonacciNumber(int n) {
        if (n <= 2){
            return 1;
        }

        int first = 1;
        int second = 1;
        int total = 0;

        for (int i = 3; i <= n; i++) {
            total = first + second;
            first = second;
            second = total;
        }

        return total;
    }
}
