import java.util.Scanner;

public class ValidUsername {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] userNames = input.split(", ");
        for (String userName : userNames) {
            if (isValidUserName(userName)) {
                System.out.println(userName);
            }
        }
    }

    static boolean isValidUserName(String userName) {
        boolean isInRange = isUserNameInRange(userName);
        boolean isAllowed = isAllowedUserName(userName);

        if (isAllowed && isInRange) {
            return true;
        }else {
            return false;
        }
    }

    public static boolean isUserNameInRange(String userName) {
        return (userName.length() >= 3 && userName.length() <= 16 ? true : false);
        //        return (userName.length() >= 3 && userName.length() <= 16); sakraten zapis zashtoto se podrazbira che izhoda shte e true ili false
    }

    public static boolean isAllowedUserName(String userName) {
        boolean isAllowed = true;
        for (int i = 0; i < userName.length(); i++) {
            char currentSymbol = userName.charAt(i);
            if (!Character.isLetterOrDigit(currentSymbol) && currentSymbol != '-' && currentSymbol != '_') {
                isAllowed = false;
            }
        }
        return isAllowed;
    }
}