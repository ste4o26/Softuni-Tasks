import java.util.Scanner;

public class EmailValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        String inputLine = sc.nextLine();

        while (!inputLine.equals("Complete")) {
            String[] tokens = inputLine.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Make":
                    String caseType = tokens[1];
                    if (caseType.equals("Upper")) {
                        email = email.toUpperCase();
                        System.out.println(email);
                    } else {
                        email = email.toLowerCase();
                        System.out.println(email);
                    }
                    break;

                case "GetDomain":
                    int lastCharactersCount = Integer.parseInt(tokens[1]);
                    int firstIndex = email.length() - lastCharactersCount;
                    String domain = email.substring(firstIndex, email.length());
                    System.out.println(domain);
                    break;

                case "GetUsername":
                    String specialSymbol = "@";
                    if (email.contains(specialSymbol)) {
                        String substring = email.substring(0, email.indexOf(specialSymbol));
                        System.out.println(substring);
                    } else {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", email);
                    }
                    break;

                case "Replace":
                    String symbolToReplace = tokens[1];
                    String replacement = "-";
                    email = email.replaceAll(symbolToReplace, replacement);
                    System.out.println(email);
                    break;

                case "Encrypt":
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < email.length(); i++) {
                        int currentSymbolAsciiValue = email.charAt(i);
                        System.out.printf("%d ", currentSymbolAsciiValue);
                    }
                    System.out.println();
                    break;
            }
            inputLine = sc.nextLine();
        }
    }
}
