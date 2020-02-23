import java.util.*;

public class ForceBook {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> userSideMap = new TreeMap<>();
        mapUsersToSides(userSideMap, sc);
        userSideMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> Integer.compare(entry1.getValue().size(), entry2.getValue().size()))
                .forEach(entry -> {
                        
                });

    }

    static void mapUsersToSides(Map<String, List<String>> userSideMap, Scanner sc) {
        String input = sc.nextLine();
        while (!input.equals("Lumpawaroo")) {
            String[] tokens = input.split(" ");
            String command = tokens[1];
            String forceSide = "";
            String forceUser = "";
            List<String> usersList = userSideMap.get(forceSide);
            switch (command) {
                case "|":
                    forceSide = tokens[0];
                    forceUser = tokens[2];
                    if (userSideMap.containsKey(forceSide)) {
                        if (!userSideMap.get(forceSide).contains(forceUser)) {
                            usersList.add(forceUser);
                            userSideMap.put(forceUser, usersList);
                        }
                    } else {
                        usersList = new ArrayList<String>();
                        usersList.add(forceUser);
                        userSideMap.put(forceSide, usersList);
                    }
                    break;

                case "->":
                    forceUser = tokens[0];
                    forceSide = tokens[1];

                    if (userSideMap.containsKey(forceSide)) {
                        for (Map.Entry<String, List<String>> entry : userSideMap.entrySet()) {
                            if (entry.getValue().contains(forceUser)) {
                                entry.getValue().remove(forceUser);
                                break;
                            }
                        }
                        userSideMap.get(forceSide).add(forceUser);
                        userSideMap.put(forceSide, usersList);
                        System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                    }else {
                        for (Map.Entry<String, List<String>> entry : userSideMap.entrySet()) {
                            if (entry.getValue().contains(forceUser)) {
                                entry.getValue().remove(forceUser);
                                break;
                            }
                        }
                        usersList = new ArrayList<>();
                        usersList.add(forceUser);
                        userSideMap.put(forceSide, usersList);
                        System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                    }
                    break;
            }


            input = sc.nextLine();
        }
    }
}
