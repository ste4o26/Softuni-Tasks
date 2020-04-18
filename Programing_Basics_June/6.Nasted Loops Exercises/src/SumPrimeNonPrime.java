import java.util.Scanner;

public class SumPrimeNonPrime {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String inputNumber = sc.nextLine();
        int primeSum = 0;
        int nonPrimeSum = 0;
        int number;

        while (!(inputNumber.equals("stop"))){

            number = Integer.parseInt(inputNumber);
            if(number < 0){
                System.out.println("Number is negative.");
                inputNumber = sc.nextLine();
                continue;
            }
            int numberDevider = 0;

            for (int i = 1; i <= number; i++) {
                if (number % i == 0){
                    numberDevider++;
                }
            }

            if (numberDevider != 2) {
                nonPrimeSum += number;
            }

            if(numberDevider == 2){
                primeSum += number;
            }

            inputNumber = sc.nextLine();
        }

        System.out.printf("Sum of all prime numbers is: %d%n", primeSum);
        System.out.printf("Sum of all non prime numbers is: %d", nonPrimeSum);
    }
}
