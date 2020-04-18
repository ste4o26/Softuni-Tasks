import java.util.Scanner;

public class MultiplyTable {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());

        int firstDigit = number % 10;
        int secondDigit = (number % 100) / 10;
        int thirdDigit = number / 100;

        int sum = 0;

        for (int table = 1; table <= firstDigit; table++) {
            for (int table2 = 1; table2 <=  secondDigit; table2++) {
                for (int table3 = 1; table3 <= thirdDigit; table3++) {
                    sum = table * table2 * table3;
                    System.out.printf("%d * %d * %d = %d;%n", table, table2, table3, sum);
                }
            }
        }
    }
}
