import java.util.Scanner;

public class RecursiveFibonacci {

    private static long[] memory;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        memory = new long[n + 1];

        long result = findFibonacci(n);
        System.out.println(result);
    }

    static long findFibonacci(int number){
        if (number < 2){
            return 1;
        }
        if (memory[number] != 0){
            return memory[number];
        }
            return memory[number] = findFibonacci(number - 1) + findFibonacci(number - 2);
    }
}
