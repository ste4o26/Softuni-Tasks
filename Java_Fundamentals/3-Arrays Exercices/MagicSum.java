import java.util.Scanner;
public class MagicSum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input[] = scanner.nextLine().split(" ");

        int numbers[] = new int[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int givenNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbers.length; i++) {
            int firstNumber = numbers[i];
            int sum = 0;
            for (int j = i; j < numbers.length; j++) {
                int secondNumber = numbers[j];
                sum = firstNumber + secondNumber;

                if(firstNumber == secondNumber){
                    continue;
                }

                if (sum == givenNumber){
                    System.out.printf("%d %d%n", firstNumber, secondNumber);
                }
            }
        }
    }
}
