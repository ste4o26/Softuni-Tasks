import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String password = sc.nextLine();
        checkPassword(password);
    }

    static void checkPassword(String password) {
        boolean isPasswordInRange = password.length() >= 6 && password.length() <= 10;
        boolean isPasswordConsistence = checkPasswordConsistence(password);
        boolean areDigitsMoreThenTwo = checkPasswordDigits(password);


        if (isPasswordInRange && isPasswordConsistence && areDigitsMoreThenTwo) {
            System.out.println("Password is valid");
        } else {
            if (!isPasswordInRange) {
                System.out.println("Password must be between 6 and 10 characters");
            }

            if (!isPasswordConsistence) {
                System.out.println("Password must consist only of letters and digits");
            }

            if (!areDigitsMoreThenTwo) {
                System.out.println("Password must have at least 2 digits");
            }
        }


    }

    static boolean checkPasswordConsistence(String password) {

        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);

            boolean isSmallLetter = (int) currentSymbol >= 97 && (int) currentSymbol <= 122;
            boolean isCapitalLetter = (int) currentSymbol >= 65 && (int) currentSymbol <= 90;
            boolean isDigit = (int) currentSymbol >= 48 && (int) currentSymbol <= 57;

            if (!isSmallLetter && !isCapitalLetter && !isDigit) {
                return false;
            }
        }
        return true;
    }

    static boolean checkPasswordDigits(String password) {
        int digitCounter = 0;

        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);

            if ((int)currentSymbol >= 48 && (int)currentSymbol <= 57) {
                digitCounter++;
            }
        }

        if(digitCounter >= 2){
            return true;
        }else {
            return false;
        }
    }
}
