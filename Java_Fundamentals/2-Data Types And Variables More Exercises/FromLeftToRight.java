import java.util.Scanner;

public class FromLeftToRight {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(sc.nextLine());

        for (int currentLine = 0; currentLine < numberOfLines; currentLine++) {
            String pairOfNumbers = sc.nextLine();

            String arrayOfNumbers[] = pairOfNumbers.split(" ");

            String firstNumber = arrayOfNumbers[0];
            String secondNumber = arrayOfNumbers[1];

            long firstNumberAsInt = Long.parseLong(arrayOfNumbers[0]);
            long secondNumberAsInt = Long.parseLong(arrayOfNumbers[1]);

            if(firstNumberAsInt >= secondNumberAsInt){
                int firstNumberSum = 0;
                int i = 0;

                if(firstNumberAsInt < 0){
                    i++;
                }
                while (i < firstNumber.length()){
                    firstNumberSum += Character.getNumericValue(firstNumber.charAt(i));
                    i++;
                }
                System.out.println(firstNumberSum);

            }else {
                int secondNumberSum = 0;
                int i = 0;

                if(secondNumberAsInt < 0){
                    i++;
                }
                while(i < secondNumber.length()){
                    secondNumberSum += Character.getNumericValue(secondNumber.charAt(i));
                    i++;
                }
                System.out.println(secondNumberSum);

            }
        }
    }
}
