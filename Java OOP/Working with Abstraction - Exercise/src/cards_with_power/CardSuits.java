package cards_with_power;

public enum CardSuits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int suitPower;

    CardSuits(int suitPower) {
        this.suitPower = suitPower;
    }

    public int getSuitPower() {
        return this.suitPower;
    }
}
