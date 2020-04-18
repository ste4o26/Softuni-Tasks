import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        operateStack(stack, sc);
    }

    static void operateStack(ArrayDeque<Integer> stack, Scanner sc){
        String[] tokens = sc.nextLine().split("\\s+");
        int elementsToPush = Integer.parseInt(tokens[0]);
        int elementsToPop = Integer.parseInt(tokens[1]);
        int elementToCheckIsPresenting = Integer.parseInt(tokens[2]);
        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(i -> Integer.parseInt(i))
                .toArray();

        fillStack(stack, elementsToPush, numbers);
        popElements(stack, elementsToPop);
        if (stack.isEmpty()){
            System.out.println(0);
        }else if (isElementPresent(stack, elementToCheckIsPresenting)){
            System.out.println("true");
        }else {
            int smallestNumber = smallestElement(stack);
            System.out.println(smallestNumber);
        }
    }

    static void fillStack(ArrayDeque<Integer> stack, int elementsToPush, int[] numbers){
        for (int i = 0; i < elementsToPush; i++) {
            stack.push(numbers[i]);
        }
    }

    static void popElements(ArrayDeque<Integer> stack, int elementsToPop){
        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }
    }

    static boolean isElementPresent(ArrayDeque<Integer> stack, int element){
        if (stack.contains(element)){
            return true;
        }else {
            return false;
        }
    }

    static int smallestElement(ArrayDeque<Integer> stack){
        int minElement = stack.pop();
        while (!stack.isEmpty()){
            int currentElement = stack.pop();
            if (currentElement < minElement){
                minElement = currentElement;
            }
        }
        return minElement;
    }
}
