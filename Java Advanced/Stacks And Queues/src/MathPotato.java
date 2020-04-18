import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        fillQueue(queue, sc);
        int n = Integer.parseInt(sc.nextLine());
        int count = 1;
        while (queue.size() > 1){
            for (int i = 0; i < n - 1; i++) {
                String currentPlayer = queue.poll();
                queue.offer(currentPlayer);
            }
            if (!isPrime(count)){
                System.out.printf("Removed %s%n", queue.poll());
            }else {
                System.out.printf("Prime %s%n", queue.peek());
            }
            count++;
        }
        System.out.printf("Last is %s%n", queue.peek());
    }

    static void fillQueue(ArrayDeque<String> queue, Scanner sc) {
        String[] input = sc.nextLine().split("\\s+");
        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }
    }

    static boolean isPrime(int number){
        if (number > 1){
            for (int i = 2; i < number; i++) {
                if (number % i == 0){
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }
}
