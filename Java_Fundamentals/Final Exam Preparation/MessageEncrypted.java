import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypted {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(sc.nextLine());
        String regex = "([*@])(?<tag>[A-Z][a-z]{2,})(?:\\1): \\[(?<firstLetter>[A-Za-z])\\]\\|\\[(?<secondLetter>[A-Za-z])\\]\\|\\[(?<thirdLetter>[A-Za-z])\\]\\|$";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < numberOfLines; i++) {
            String inputLine = sc.nextLine();
            Matcher matcher = pattern.matcher(inputLine);
            if(matcher.find()){
                String tagName = matcher.group("tag");
                int firstLetterCode = matcher.group("firstLetter").charAt(0);
                int secondLetterCode = matcher.group("secondLetter").charAt(0);
                int thirdLetterCode = matcher.group("thirdLetter").charAt(0);
                System.out.printf("%s: %d %d %d%n", tagName, firstLetterCode, secondLetterCode, thirdLetterCode);
            }else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
