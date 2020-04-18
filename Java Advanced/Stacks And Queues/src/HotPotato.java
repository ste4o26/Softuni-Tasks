import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        fillQueue(queue, sc);
        int n = Integer.parseInt(sc.nextLine());
        while (queue.size() > 1) {
            for (int i = 0; i < n - 1; i++) {
                String currentPlayer = queue.poll();
                queue.offer(currentPlayer);
            }
            System.out.printf("Removed %s%n", queue.poll());
        }
        System.out.printf("Last is %s%n", queue.peek());
    }

    static void fillQueue(ArrayDeque<String> queue, Scanner sc) {
        String[] input = sc.nextLine().split("\\s+");
        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }
    }
}
