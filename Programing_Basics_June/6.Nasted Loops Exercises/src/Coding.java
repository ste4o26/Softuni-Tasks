import java.util.Scanner;

public class Coding {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int length = input.length();
        int number = Integer.parseInt(input);
        int currentDigit;

        for (int row = length-1; row >= 0; row--) {
            char digit = input.charAt(row);

            //vmesto taka da gi prevrushtam v int moga da parsvam po tozi nachin
            //currentDigit = Integer.parseInt("" + digit)
            currentDigit = number % 10;
            number = number / 10;

            char symbol = (char)(currentDigit + 33);

            if(currentDigit == 0){
                System.out.println("ZERO");
                continue;
            }

            for (int col = 0; col < currentDigit; col++) {
                System.out.print(symbol);
            }
            System.out.println();
        }

    }
}
