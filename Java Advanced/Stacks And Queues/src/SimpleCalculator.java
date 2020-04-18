import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        fillStack(sc, stack);

        while (stack.size() > 1){
            int firstNumber = Integer.parseInt(stack.pop());
            String operand = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());
            int sum = 0;
            if(operand.equals("+")){
                sum = firstNumber + secondNumber;
                String numberAsString = sum + "";
                stack.push(numberAsString);
            }else {
                sum = firstNumber - secondNumber;
                String numberAsString = sum + "";
                stack.push(numberAsString);
            }
        }

        System.out.println(stack.peek());
    }

    static void fillStack(Scanner sc, ArrayDeque<String> stack){
        String[] input = sc.nextLine().split("\\s+");
        for (int i = input.length - 1; i >= 0; i--) {
            String currentElement = input[i];
            stack.push(currentElement);
        }
    }
}
