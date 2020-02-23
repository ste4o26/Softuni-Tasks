import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardsGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondDeck = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        compareDecks(firstDeck, secondDeck, sc);
        printWinner(firstDeck, secondDeck);

    }

    static void compareDecks(List<Integer> firstDeck, List<Integer> secondDeck, Scanner sc){
        int smallestDeck = Math.min(firstDeck.size(), secondDeck.size());


        while (smallestDeck > 0){
            int firstDeckCurrentCard = firstDeck.get(0);
            int secondDeckCurrentCard = secondDeck.get(0);

            if(firstDeckCurrentCard > secondDeckCurrentCard){
                firstDeck.add(firstDeckCurrentCard);
                firstDeck.add(secondDeckCurrentCard);
                firstDeck.remove(0);
                secondDeck.remove(0);

            }else if(firstDeckCurrentCard < secondDeckCurrentCard){
                secondDeck.add(secondDeckCurrentCard);
                secondDeck.add(firstDeckCurrentCard);
                secondDeck.remove(0);
                firstDeck.remove(0);

            }else {
                //ako sa ravni
                firstDeck.remove(0);
                secondDeck.remove(0);
            }

            smallestDeck = Math.min(firstDeck.size(), secondDeck.size());

        }
    }

    static void printWinner(List<Integer> firstDeck, List<Integer> secondDeck){
        int biggestDeck = Math.max(firstDeck.size(), secondDeck.size());
        int sum = 0;
        boolean isFirstPlayerWinner = firstDeck.size() > secondDeck.size();
        for (int i = 0; i < biggestDeck; i++) {
            int currentCard = 0;
            if(isFirstPlayerWinner) {
                currentCard = firstDeck.get(i);
                sum += currentCard;
            }else {
                currentCard = secondDeck.get(i);
                sum += currentCard;
            }
        }

        if(isFirstPlayerWinner) {
            System.out.printf("First player wins! Sum: %d", sum);
        }else {
            System.out.printf("Second player wins! Sum: %d", sum);
        }

    }
}
