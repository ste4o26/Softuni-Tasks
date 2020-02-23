import java.util.Scanner;

public class CharacerManipulator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        String firstString = input[0];
        String secondString = input[1];
        int sum = sumOfStrings(firstString, secondString);
        System.out.println(sum);
    }

    public static int sumOfStrings(String firstString, String secondString){
        int maxLength = Integer.max(firstString.length(), secondString.length());
        int result = 0;
        int lastSymbolsSum = 0;
        for (int i = 0; i < maxLength; i++) {
            int firstStringCurrentSymbol = 1;
            int secondStringCurrentSymbol = 1;
            if(i < firstString.length()){
                firstStringCurrentSymbol = firstString.charAt(i);
            }
            if(i < secondString.length()){
                secondStringCurrentSymbol = secondString.charAt(i);
            }
            int currentSymbolsMultiplication = firstStringCurrentSymbol * secondStringCurrentSymbol;
            result += currentSymbolsMultiplication;
        }
        return result;
    }
}
