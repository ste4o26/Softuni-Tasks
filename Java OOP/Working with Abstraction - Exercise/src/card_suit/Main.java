package card_suit;

public class Main {

    public static void main(String[] args) {

        CardSuits[] cardValues = CardSuits.values();

        System.out.println("Card Suits:");
        for (int i = 0; i < cardValues.length; i++) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s",cardValues[i].getOrdinalValues(), cardValues[i]));
        }
    }
}
