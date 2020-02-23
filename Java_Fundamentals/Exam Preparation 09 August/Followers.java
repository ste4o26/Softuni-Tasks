import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Followers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> followersLikes = new TreeMap<>();
        Map<String, Integer> followersComments = new TreeMap<>();
        String inputLine = sc.nextLine();

        while (!inputLine.equals("Log out")) {
            String[] tokens = inputLine.split(": ");
            String command = tokens[0];
            String userName = tokens[1];
            switch (command) {
                case "New follower":
                    followersLikes.putIfAbsent(userName, 0);
                    followersComments.putIfAbsent(userName, 0);
                    break;

                case "Like":
                    int likesCount = Integer.parseInt(tokens[2]);
                    if (!followersLikes.containsKey(userName)) {
                        followersLikes.put(userName, likesCount);
                        followersComments.put(userName, 0);
                    } else {
                        int newLikesCount = likesCount + followersLikes.get(userName);
                        followersLikes.put(userName, newLikesCount);
                    }
                    break;

                case "Comment":
                    if (!followersComments.containsKey(userName)) {
                        followersComments.put(userName, 1);
                        followersLikes.put(userName, 0);
                    } else {
                        int commentsCount = followersComments.get(userName);
                        followersComments.put(userName, commentsCount + 1);
                    }
                    break;

                case "Blocked":
                    if (followersLikes.containsKey(userName) && followersComments.containsKey(userName)) {
                        followersLikes.remove(userName);
                        followersComments.remove(userName);
                    } else {
                        System.out.printf("%s doesn't exist.%n", userName);
                    }
                    break;
            }

            inputLine = sc.nextLine();
        }

        System.out.println(followersLikes.size() + " followers");
        followersLikes.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue() + followersComments.get(entry.getKey())));

    }
}
