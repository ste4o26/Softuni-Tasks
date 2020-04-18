import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (number == 0) {
            System.out.println(0);
            return;
            //stack.push(number); i tova e vqrno prosto pravq edna proverka poveche demek v while cikula
        }

        while (number >= 0) {
            int reminder = number % 2;
            stack.push(reminder);
            number /= 2;
        }

        printStack(stack);
    }

    static void printStack(ArrayDeque<Integer> stack) {
        while (!stack.isEmpty()) {
            int currentBinaryDigit = stack.pop();
            System.out.print(currentBinaryDigit);
        }
    }
}
