package cards_with_power;

public class Card {
    private String cardRank;
    private String cardSuit;

    public Card(String cardRank, String cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public String getCardRank() {
        return this.cardRank;
    }

    public String getCardSuit() {
        return this.cardSuit;
    }

    public int calculateCardPower() {
        int rankPower = CardRanks.valueOf(getCardRank()).getRankPower();
        int suitPower = CardSuits.valueOf(getCardSuit()).getSuitPower();
        return rankPower + suitPower;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.getCardRank(),
                this.getCardSuit(),
                this.calculateCardPower());
    }
}
