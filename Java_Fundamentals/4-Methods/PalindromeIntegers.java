import java.util.Scanner;
public class PalindromeIntegers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

    //    int reversedNumber = reverseNumber(input);
        checkForPalindromes(input, sc);
    }

    static int reverseNumber(String input){
        String reversed = "";
        for (int i = input.length()-1; i >= 0; i--) {
           reversed += input.charAt(i);
        }

        int reversedNumber = Integer.parseInt(reversed);
        return reversedNumber;
    }

    static void checkForPalindromes(String input, Scanner sc){

        while (!input.equals("END")){
            int number = Integer.parseInt(input);
            int reversedNumber = reverseNumber(input);

            if (number == reversedNumber){
                System.out.println("true");
            }else {
                System.out.println("false");
            }

            input = sc.nextLine();
        }

    }
}
