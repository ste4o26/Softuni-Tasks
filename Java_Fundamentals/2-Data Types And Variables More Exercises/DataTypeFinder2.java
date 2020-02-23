import java.util.Scanner;
import java.io.*;

public class DataTypeFinder2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = "";

        while (true) {
            input = sc.nextLine();
            boolean isCharacter = input.length() == 1;

            if(input.equalsIgnoreCase("end")){
                break;
            }


            if (isInteger(input)) {
                System.out.printf("%s is integer type%n", input);

            }else if(isDouble(input)){
                System.out.printf("%s is floating point type%n", input);

            }else if(isCharacter){
                System.out.printf("%s is character type%n", input);

            }else if((input.equalsIgnoreCase("true")) || (input.equalsIgnoreCase("false"))){
                System.out.printf("%s is boolean type%n", input);

            } else {
                System.out.printf("%s is string type%n", input);
            }
        }

    }

    public static boolean isInteger(String input) {
        try {
            int integerNumber = Integer.parseInt(input);

        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isDouble(String input){
        try{
            double doubleNumber = Double.parseDouble(input);

        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }
}
