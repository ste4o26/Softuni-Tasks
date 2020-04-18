import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String sequence = "";
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String command = tokens[0];

            switch (command) {
                case "1":
                    stack.push(sequence);
                    String string = tokens[1];
                    sequence += string;
                    break;

                case "2":
                    stack.push(sequence);
                    int count = Integer.parseInt(tokens[1]);
                    sequence = eraseSymbols(sequence, count);
                    break;

                case "3":
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(sequence.charAt(index - 1));
                    break;

                case "4":
                    sequence = stack.pop();
                    break;
            }
        }
    }
        Scanner scanner = new Scanner(System.in);

    static String eraseSymbols(String sequence, int count){
        StringBuilder sb = new StringBuilder();
        sb.append(sequence);
        sb.replace(sb.length() - count, sb.length(), "");
        return sb.toString();
    }
}
