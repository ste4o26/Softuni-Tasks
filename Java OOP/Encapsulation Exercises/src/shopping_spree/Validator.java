package shopping_spree;

public class Validator {

    public static void validateNotEmptyName(String name){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public static void validateNotNegativeMoney(double money){
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public static void validateCost(double cost){
        validateNotNegativeMoney(cost);
    }
}
