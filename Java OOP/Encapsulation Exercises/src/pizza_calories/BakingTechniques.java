package pizza_calories;

public enum BakingTechniques {
    Crispy(0.9),
    Chewy(1.1),
    Homemade(1.0);

    private double modifier;

    BakingTechniques(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }
}
