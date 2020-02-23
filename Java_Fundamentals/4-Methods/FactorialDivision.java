import java.util.Scanner;

public class FactorialDivision {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double firstNumber = Double.parseDouble(sc.nextLine());
        double secondNumber = Double.parseDouble(sc.nextLine());

        double firstNumberFactorial = findFactorialOfAGivenNumber(firstNumber);
        double secondNumberFactorial = findFactorialOfAGivenNumber(secondNumber);

        double result = divideFactorials(firstNumberFactorial, secondNumberFactorial);
        System.out.printf("%.2f", result);
    }

    static double divideFactorials(double firstFactorial, double secondFactorial) {
        double result = firstFactorial * (1 / secondFactorial);
        return result;
    }

    static double findFactorialOfAGivenNumber(double number) {

        if (number == 0) {
            return 1;
        } else {
            int factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            return factorial;
        }
    }


}
