import java.util.Scanner;
public class Login {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String username = sc.nextLine();
        String userPassword = "";

        int passwordLength = username.length();
        boolean isLoggedIn = true;

        for (int inex = passwordLength - 1; inex >= 0; inex--) {
            userPassword = userPassword + username.charAt(inex);
        }
        // System.out.println(password);

        String passwordGuess = sc.nextLine();
        int numberOfMistakenPassords = 0;

        while (!(passwordGuess.equals(userPassword))) {
            numberOfMistakenPassords++;

            if (numberOfMistakenPassords >= 4) {
                isLoggedIn = false;
                break;
            }

            System.out.println("Incorrect password. Try again.");
            passwordGuess = sc.nextLine();
        }

        if (isLoggedIn) {
            System.out.printf("User %s logged in.", username);
        }else {
            System.out.printf("User %s blocked!", username);
        }
    }
}