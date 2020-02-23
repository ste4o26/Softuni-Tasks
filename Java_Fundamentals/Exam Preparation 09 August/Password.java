import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(sc.nextLine());
        String regex = "^(.+)>(?<digits>\\d{3})\\|(?<lowerCaseLetters>[a-z]{3})\\|(?<capitalCaseLetters>[A-Z]{3})\\|(?<symbols>[^<>]{3})<\\1$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < numberOfLines; i++) {
            String inputLine = sc.nextLine();
            Matcher matcher = pattern.matcher(inputLine);
            if(matcher.find()){
                String digits = matcher.group("digits");
                String lowerCaseLetters = matcher.group("lowerCaseLetters");
                String capitalCaseLetters = matcher.group("capitalCaseLetters");
                String symbols = matcher.group("symbols");
                StringBuilder encryptedPassword = new StringBuilder();
                encryptedPassword
                        .append(digits)
                        .append(lowerCaseLetters)
                        .append(capitalCaseLetters)
                        .append(symbols);

                System.out.printf("Password: %s%n", encryptedPassword);
            }else {
                System.out.printf("Try another password!%n");
            }
        }
    }
}
