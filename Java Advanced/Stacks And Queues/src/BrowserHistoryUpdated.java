import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdated {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> urlStack = new ArrayDeque<>();
        ArrayDeque<String> backedURLStack = new ArrayDeque<>();
        String input = sc.nextLine();
        while (!input.equalsIgnoreCase("Home")) {
            if (input.equalsIgnoreCase("back")) {
                if (urlStack.size() > 1) {
                    String url = urlStack.pop();
                    backedURLStack.push(url);
                    System.out.println(urlStack.peek());

                } else {
                    System.out.println("no previous URLs");

                }

            } else if (input.equalsIgnoreCase("forward")) {
                if (backedURLStack.size() >= 1) {
                    String url = backedURLStack.pop();
                    urlStack.push(url);
                    System.out.println(urlStack.peek());

                } else {
                    System.out.println("no next URLs");

                }

            } else {
                urlStack.push(input);
                System.out.println(input);
                backedURLStack.clear();
            }

            input = sc.nextLine();
        }
    }
}
