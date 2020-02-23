import java.util.*;

public class InboxManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> usersEmails = new TreeMap<>();
        String inputLine = sc.nextLine();
        while (!inputLine.equals("Statistics")) {
            String[] tokens = inputLine.split("->");
            String command = tokens[0];
            String userName = tokens[1];
            List<String> emails = usersEmails.get(userName);
            switch (command) {
                case "Add":
                    if (usersEmails.containsKey(userName)) {
                        System.out.printf("%s is already registered%n", userName);
                    } else {
                        emails = new ArrayList<>();
                        usersEmails.put(userName, emails);
                    }
                    break;

                case "Send":
                    String email = tokens[2];
                    emails.add(email);
                    usersEmails.put(userName, emails);
                    break;

                case "Delete":
                    if (usersEmails.containsKey(userName)) {
                        usersEmails.remove(userName);
                    } else {
                        System.out.printf("%s not found!%n", userName);
                    }
                    break;
            }

            inputLine = sc.nextLine();
        }

        System.out.printf("Users count: %d%n", usersEmails.size());
        usersEmails
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("%s%n", entry.getKey());
                    for (int i = 0; i < entry.getValue().size() ; i++) {
                        String currentEmail = entry.getValue().get(i);
                        System.out.printf(" - %s%n", currentEmail);
                    }
                });
    }
}
