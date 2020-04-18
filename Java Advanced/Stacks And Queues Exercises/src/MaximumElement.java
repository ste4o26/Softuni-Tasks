import java.util.*;
import java.util.stream.Collectors;

public class MaximumElement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> maxNumbersStack = new ArrayDeque<>();
        int bestNumber = Integer.MIN_VALUE;


        for (int i = 1; i <= n; i++) {
            String input = sc.nextLine();
            String[] tokens = input.split("\\s+");
            int command = Integer.parseInt(tokens[0]);

            switch (command) {
                case 1:
                    int element = Integer.parseInt(tokens[1]);
                    stack.push(element);
                    if (element > bestNumber) {
                        bestNumber = element;
                        maxNumbersStack.push(bestNumber);
                    }

                    break;

                case 2:
                    if (!stack.isEmpty()) {
                        int lastElement = stack.pop();
                        if (lastElement == bestNumber) {
                            maxNumbersStack.pop();
                            if (!maxNumbersStack.isEmpty()) {
                                bestNumber = maxNumbersStack.peek();
                            } else {
                                bestNumber = Integer.MIN_VALUE;
                            }
                        }

                    }
                    break;

                case 3:
                    System.out.println(bestNumber);

                    break;
            }
        }
    }
}
