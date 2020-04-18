import java.util.Scanner;

public class OperationsBetweenNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double num1 = Double.parseDouble(sc.nextLine());
        double num2 = Double.parseDouble(sc.nextLine());

        double answer = 0;

        char operator = sc.nextLine().charAt(0);

        boolean isEven = false;
        boolean isNotDevidableBy0 = num2 == 0;


        switch (operator) {

            case '+':
                answer = num1 + num2;
                isEven = answer % 2 == 0;

                if (isEven) {
                    System.out.printf("%.0f + %.0f = %.0f - even", num1, num2, answer);

                } else {
                    System.out.printf("%.0f + %.0f = %.0f - odd", num1, num2, answer);
                }
                break;

            case '-':
                answer = num1 - num2;
                isEven = answer % 2 == 0;

                if (isEven) {
                    System.out.printf("%.0f - %.0f = %.0f - even", num1, num2, answer);

                } else {
                    System.out.printf("%.0f - %.0f = %.0f - odd", num1, num2, answer);
                }
                break;

            case '*':
                answer = num1 * num2;
                isEven = answer % 2 == 0;

                if (isEven) {
                    System.out.printf("%.0f * %.0f = %.0f - even", num1, num2, answer);

                } else {
                    System.out.printf("%.0f * %.0f = %.0f - odd", num1, num2, answer);
                }
                break;

            case '/':

                if (isNotDevidableBy0) {
                    System.out.printf("Cannot divide %.0f by zero", num1);

                } else {
                    answer = num1 / num2;
                    System.out.printf("%.0f / %.0f = %.2f", num1, num2, answer);
                }
                break;

            case '%':

                char simbol = '%';

                if (isNotDevidableBy0) {
                    System.out.printf("Cannot divide %.0f by zero", num1);

                } else {
                    answer = num1 % num2;
                    System.out.printf("%.0f %c %.0f = %.0f", num1, simbol, num2, answer);

                    break;
                }
        }
    }
}
