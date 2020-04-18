package card_rank;
public class Main {
    public static void main(String[] args) {

        System.out.println("Card Ranks:");
        CardRanks[] cards = CardRanks.values();
        for (int i = 0; i < cards.length; i++) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s", cards[i].getRank(), cards[i]));
        }

    }
}
