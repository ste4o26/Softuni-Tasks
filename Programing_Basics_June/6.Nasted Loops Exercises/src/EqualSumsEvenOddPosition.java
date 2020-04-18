import java.util.Scanner;

public class EqualSumsEvenOddPosition {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String firstInput = sc.nextLine();
        String secondInput = sc.nextLine();

        int firstNumber = Integer.parseInt(firstInput);
        int secondNumber = Integer.parseInt(secondInput);

        int length = firstInput.length();

        for (int number = firstNumber; number <= secondNumber; number++) {
            int evenPositionSum = 0;
            int oddPositionSum = 0;

            for (int numberPosition = 0; numberPosition < length; numberPosition++) {

                String currentNumber = Integer.toString(number);
                char currentDigit = currentNumber.charAt(numberPosition);
                int digit = Integer.parseInt("" + currentDigit);

                if((numberPosition+1) % 2 == 0){
                   evenPositionSum += digit;
                }else {
                    oddPositionSum += digit;
                }
            }

            if(evenPositionSum == oddPositionSum){
                System.out.print(number + " ");
            }
        }
    }
}
