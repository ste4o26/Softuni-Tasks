package pizza_calories;

public class PizzaValidator {

    public static void validatePizzaName(String name){
        if (name == null || isNameOutOfRange(name)){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    private static boolean isNameOutOfRange(String name) {
        return isEmptyName(name) || name.trim().length() < 1 || name.trim().length() > 15;
    }

    private static boolean isEmptyName(String name) {
        return name.trim().isEmpty();
    }

    public static void validateNumberOfToppings(int numberOfToppings){
        if (!areToppingsInRange(numberOfToppings)){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    private static boolean areToppingsInRange(int numberOfToppings) {
        return numberOfToppings >= 0 && numberOfToppings <= 10;
    }
}
