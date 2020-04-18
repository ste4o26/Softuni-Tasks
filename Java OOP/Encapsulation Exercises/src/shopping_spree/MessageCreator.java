package shopping_spree;

public class MessageCreator {

    public static String boughtProductMessage(Person person, Product product) {
        return String.format("%s bought %s",
                person.getName(),
                product.getName());
    }

    public static void cantAffordProductMessage(Person person, Product product) {
        throw new IllegalArgumentException(String.format("%s can't afford %s",
                person.getName(),
                product.getName()));
    }
}
