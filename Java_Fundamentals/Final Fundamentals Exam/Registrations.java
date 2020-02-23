import javafx.css.Match;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registrations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(sc.nextLine());
        int successfullRegistrationsCount = 0;
        String regex = "[U$]{2}(?<userName>[A-Z][a-z]{2,})[U$]{2}[P@$]{3}(?<pass>[A-Za-z]{5,}\\d+)[P@$]{3}";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < numberOfLines; i++) {
            String inputLine = sc.nextLine();
            Matcher matcher = pattern.matcher(inputLine);
            if(matcher.find()){
                String userName = matcher.group("userName");
                String password = matcher.group("pass");
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n", userName, password);
                successfullRegistrationsCount++;
            }else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.printf("Successful registrations: %d", successfullRegistrationsCount);
    }
}
