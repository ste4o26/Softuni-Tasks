package pizza_calories;

public class ToppingValidator {

    public static void validateToppingWeight(String toppingType, double weight){
        if (!isValidToppingWeight(weight)){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    private static boolean isValidToppingWeight(double weight) {
        return weight >= 1 && weight <= 50;
    }


}
