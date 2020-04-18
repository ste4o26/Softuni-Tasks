import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class BrowserHistory {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!inputLine.equals("Home")) {
            if (!inputLine.equals("back")) {
                stack.push(inputLine);
                System.out.println(stack.peek());
            } else {
                if (stack.size() > 1) {
                    stack.pop();
                    String lastURL = stack.peek();
                    System.out.println(lastURL);
                }else {
                    System.out.println("no previous URLs");
                }
            }

            inputLine = sc.nextLine();
        }
    }

}
