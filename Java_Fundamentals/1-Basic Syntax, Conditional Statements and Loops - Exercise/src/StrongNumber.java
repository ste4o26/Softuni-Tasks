import java.util.Scanner;

public class StrongNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
        int myNumber = number;
        int sum = 0;
        int digit;


        while (myNumber > 0) {
            digit = myNumber % 10;
            myNumber /= 10;
            int factorialOfTheNumber = 1;
            for (int currentDigit = digit; currentDigit >= 1; currentDigit--) {
               factorialOfTheNumber *= currentDigit;
            }
            sum += factorialOfTheNumber;
        }
        if(number == sum){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
