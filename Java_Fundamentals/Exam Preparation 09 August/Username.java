import java.util.Scanner;

public class Username {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        String inputLine = sc.nextLine();

        while (!inputLine.equals("Sign up")) {
            String[] tokens = inputLine.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Case":
                    String caseType = tokens[1];
                    if (caseType.equals("lower")) {
                        userName = userName.toLowerCase();
                    } else {
                        userName = userName.toUpperCase();
                    }
                    System.out.println(userName);
                    break;

                case "Reverse":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (startIndex >= 0 && endIndex < userName.length()) {
                        StringBuilder reversedString = new StringBuilder(userName.substring(startIndex, endIndex + 1));
                        System.out.println(reversedString.reverse());
                    }
                    break;

                case "Cut":
                    String substringToCut = tokens[1];
                    if (userName.contains(substringToCut)) {
                        userName = userName.replace(substringToCut, "");
                        System.out.println(userName);
                    } else {
                        System.out.printf("The word %s doesn't contain %s.%n", userName, substringToCut);
                    }
                    break;

                case "Replace":
                    String replacement = "*";
                    String symbolToReplace = tokens[1];
                    userName = userName.replaceAll(symbolToReplace, replacement);
                    System.out.println(userName);
                    break;

                case "Check":
                    String symbol = tokens[1];
                    if(userName.contains(symbol)){
                        System.out.println("Valid");
                    }else {
                        System.out.printf("Your username must contain %s.%n", symbol);
                    }
                    break;
            }

            inputLine = sc.nextLine();
        }
    }
}
