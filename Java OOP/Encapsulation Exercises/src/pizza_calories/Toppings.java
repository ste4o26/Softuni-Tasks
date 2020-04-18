package pizza_calories;

public enum Toppings {

    Meat(1.2),
    Veggies(0.8),
    Cheese(1.1),
    Sauce(0.9);

    private double modifier;

    Toppings(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }
}
