import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int index = -1;
        int endIndex = -1;
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            if (currentCharacter == '('){
                index = input.indexOf(currentCharacter, index + 1);
                stack.push(index);
            }else if (currentCharacter == ')'){
                endIndex = input.indexOf(currentCharacter, endIndex + 1);
                int startIndex = stack.pop();
                String currentExpression = input.substring(startIndex, endIndex + 1);
                System.out.println(currentExpression);
            }
        }
    }
}
