import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        fillStack(stack, sc);
        printStack(stack);
    }

    static void fillStack(ArrayDeque<Integer> stack, Scanner sc){
        String[] numbersAsStrings = sc.nextLine().split("\\s+");
        for (int i = 0; i < numbersAsStrings.length; i++) {
            stack.push(Integer.parseInt(numbersAsStrings[i]));
        }
    }

    static void printStack(ArrayDeque<Integer> stack){
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
