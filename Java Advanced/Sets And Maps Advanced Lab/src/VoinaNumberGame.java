import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Set<Integer> firstPlayerDeck = fillSet(sc.nextLine());
        Set<Integer> secondPlayerDeck = fillSet(sc.nextLine());

        for (int round = 0; round < 50; round++) {
            if (firstPlayerDeck.isEmpty() || secondPlayerDeck.isEmpty()) {
                break;
            }

            Iterator<Integer> firstPlayerIterator = firstPlayerDeck.iterator();
            int firstPlayerCard = firstPlayerIterator.next();
            firstPlayerDeck.remove(firstPlayerCard);

            Iterator<Integer> secondPlayerIterator = secondPlayerDeck.iterator();
            int secondPlayerCard = secondPlayerIterator.next();
            secondPlayerDeck.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);

            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);

            } else {
                firstPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }
        }

        if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerDeck.size() > firstPlayerDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    static LinkedHashSet<Integer> fillSet(String input) {
        String[] tokens = input.split("\\s+");
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(e -> set.add(e)); // equivalent -> .foreach(set::add);
        return set;
    }
}
