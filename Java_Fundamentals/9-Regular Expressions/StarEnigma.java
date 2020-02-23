import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(sc.nextLine());
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < numberOfLines; i++) {
            String inputLine = sc.nextLine();
            String keyRegex = "[star]";
            Pattern keyPattern = Pattern.compile(keyRegex, Pattern.CASE_INSENSITIVE);
            Matcher keyMatcher = keyPattern.matcher(inputLine);
            int key = 0;

            for (int k = 0; k < inputLine.length(); k++) {
                if (keyMatcher.find()){
                    key++;
                }
            }

            StringBuilder decryptedMessage = new StringBuilder();
            for (int o = 0; o < inputLine.length(); o++) {
                char currentLetter = inputLine.charAt(o);
                decryptedMessage.append((char)(currentLetter - key));
            }

            String regex = "@(?<name>[A-Za-z]+)(?:[^@\\-!:>]*):(?<population>\\d+)(?:[^@\\-!:>]*)!(?<attackType>[AD])!(?:[^@\\-!:>]*)->(?<soldiersCount>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedMessage);

            while (matcher.find()) {
                String planetName = matcher.group("name");
                String attackType = matcher.group("attackType");

                switch (attackType){
                    case "A": attackedPlanets.add(planetName);
                    break;

                    case "D": destroyedPlanets.add(planetName);
                    break;
                }
            }
        }

        System.out.println("Attacked planets: " + attackedPlanets.size());
        attackedPlanets.stream()
                .sorted((e1, e2) -> e1.compareTo(e2))
                .forEach(e -> System.out.println("-> " + e));

        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        destroyedPlanets.stream()
                .sorted((e1, e2) -> e1.compareTo(e2))
                .forEach(e -> System.out.println("-> " + e));
    }
}
