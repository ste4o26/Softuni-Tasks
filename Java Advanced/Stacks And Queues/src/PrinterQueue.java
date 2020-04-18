import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String canceledFile = queue.poll();
                    System.out.println("Canceled " + canceledFile);
                }
            } else {
                queue.offer(input);
            }
            input = sc.nextLine();
        }

        printQueue(queue);
    }

    static void printQueue(ArrayDeque<String> queue) {
        while (!queue.isEmpty()) {
            String currentFile = queue.poll();
            System.out.println(currentFile);
        }
    }
}
