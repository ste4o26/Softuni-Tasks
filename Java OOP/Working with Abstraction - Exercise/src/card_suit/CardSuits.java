package card_suit;

public enum CardSuits {

    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    private int ordinalValues;

    CardSuits(int ordinalValues) {
        this.ordinalValues = ordinalValues;
    }

    public int getOrdinalValues() {
        return this.ordinalValues;
    }
}
