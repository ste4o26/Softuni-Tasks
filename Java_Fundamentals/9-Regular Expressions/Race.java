import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> racers = Arrays
                .stream(sc.nextLine()
                        .split(", "))
                .collect(Collectors.toList());

        Map<String, Integer> racersDistance = new LinkedHashMap<>();
        validRacer(sc, racers, racersDistance);
        int[] count = {1};
        racersDistance.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(3)
                .forEach(entry -> {
                    switch (count[0]) {
                        case 1: System.out.printf("1st place: %s%n", entry.getKey()); break;
                        case 2: System.out.printf("2nd place: %s%n", entry.getKey()); break;
                        case 3: System.out.printf("3rd place: %s%n", entry.getKey()); break;
                    }
                    count[0]++;
                });
    }

    static void validRacer(Scanner sc, List<String> racers, Map<String, Integer> racersDistance) {
        String nameRegex = "([A-Za-z]+)";
        String distanceRegex = "\\d";
        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern distancePattern = Pattern.compile(distanceRegex);

        String inputLine = sc.nextLine();
        while (!inputLine.equals("end of race")) {
            Matcher nameMatcher = namePattern.matcher(inputLine);
            StringBuilder sb = new StringBuilder();
            while (nameMatcher.find()) {
                String currentLetter = nameMatcher.group();
                sb.append(currentLetter);
            }
            String currentRacerName = sb.toString();
            if (racers.contains(currentRacerName)) {
                int currentRacerDistance = 0;
                Matcher distanceMatcher = distancePattern.matcher(inputLine);
                while (distanceMatcher.find()) {
                    int currentDigit = Integer.parseInt(distanceMatcher.group());
                    currentRacerDistance += currentDigit;
                }

                if (racersDistance.containsKey(currentRacerName)) {
                    int newRacerDistance = racersDistance.get(currentRacerName) + currentRacerDistance;
                    racersDistance.put(currentRacerName, newRacerDistance);
                } else {
                    racersDistance.put(currentRacerName, currentRacerDistance);
                }
            }

            inputLine = sc.nextLine();
        }
    }

}
