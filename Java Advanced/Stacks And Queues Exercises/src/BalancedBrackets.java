import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedBrackets {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isValid = false;

        if (input.length() % 2 != 0){
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (currentSymbol == '{' || currentSymbol == '(' || currentSymbol == '['){
                stack.push(currentSymbol);
            }else {
                char topSymbol = stack.pop();
                if (topSymbol == '{' && currentSymbol == '}'){
                    isValid = true;
                    break;
                }else if (topSymbol == '(' && currentSymbol == ')'){
                    isValid = true;
                    break;
                }else if (topSymbol == '[' && currentSymbol == ']'){
                    isValid = true;
                    break;
                }else {
                    break;
                }
            }
        }

        if (isValid){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
