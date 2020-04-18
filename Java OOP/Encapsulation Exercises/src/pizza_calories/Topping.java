package pizza_calories;

public class Topping{
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private String getToppingType() {
        return this.toppingType;
    }

    private void setToppingType(String toppingType) {
        this.toppingType = toppingType;
    }

    private double getWeight() {
        return this.weight;
    }

    private void setWeight(double weight) {
        ToppingValidator.validateToppingWeight(getToppingType(), weight);
        this.weight = weight;
    }

    public double calculateCalories(){
        String toppingType = getToppingType();
        double toppingTypeModifier = Toppings.valueOf(toppingType).getModifier();
        double weight = getWeight();

        return (2 * weight) * toppingTypeModifier;
    }
}
