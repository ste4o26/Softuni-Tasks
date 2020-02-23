import java.util.Scanner;
public class TopInteger {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input[] = scanner.nextLine().split(" ");
        int numbers[] = new int[input.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            boolean isTopInteger = true;

            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] <= numbers[j]) {
                    isTopInteger = false;
                    break;
                }

            }

            if(isTopInteger){
                System.out.printf("%d ", numbers[i]);
            }
        }
    }
}
