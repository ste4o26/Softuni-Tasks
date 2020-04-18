import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HandsOfCards {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        Map<String, Set<String>> playersPoints = new LinkedHashMap<>();

        while (!"JOKER".equals(inputLine)) {
            String[] tokens = inputLine.split(":\\s+");
            String name = tokens[0];
            String[] cards = tokens[1].split(",\\s+");
            Set<String> listOfCards = playersPoints.get(name);

            if (!playersPoints.containsKey(name)) {
                listOfCards = new LinkedHashSet<>();
                listOfCards.addAll(Arrays.asList(cards));
                playersPoints.put(name, listOfCards);
            } else {
                listOfCards.addAll(Arrays.asList(cards));
                playersPoints.put(name, listOfCards);
            }

            inputLine = reader.readLine();
        }

        System.out.println();
        for (Map.Entry<String, Set<String>> player : playersPoints.entrySet()) {
            Set<String> listOfCards = player.getValue();
            int currentPlayerTotalPoints = 0;
            for (String card : listOfCards) {
                currentPlayerTotalPoints += getPoints(card);
            }
            String name = player.getKey();
            String result = String.format("%s: %d", name, currentPlayerTotalPoints);
            System.out.println(result);
        }
    }

    private static int getPoints(String card) {
        int power = -1;
        int type = -1;

        if (card.length() == 3) {
            power = 10;
            switch (String.valueOf(card.charAt(2))) {
                case "S":
                    type = 4;
                    break;

                case "H":
                    type = 3;
                    break;

                case "D":
                    type = 2;
                    break;

                case "C":
                    type = 1;
                    break;
            }

        } else {
            if (Character.isDigit(card.charAt(0))) {
                power = Integer.parseInt(String.valueOf(card.charAt(0)));
            } else {
                switch (String.valueOf(card.charAt(0))) {
                    case "J":
                        power = 11;
                        break;

                    case "Q":
                        power = 12;
                        break;

                    case "K":
                        power = 13;
                        break;

                    case "A":
                        power = 14;
                        break;
                }
            }

            switch (String.valueOf(card.charAt(1))) {
                case "S":
                    type = 4;
                    break;

                case "H":
                    type = 3;
                    break;

                case "D":
                    type = 2;
                    break;

                case "C":
                    type = 1;
                    break;
            }
        }
        return power * type;
    }
}
