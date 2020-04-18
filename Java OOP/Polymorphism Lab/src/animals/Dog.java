package animals;

public class Dog extends Animal {
    private static final String BARK = "DJAAF";

    private String name;
    private String favouriteFood;

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s%n%s",
                super.getName(),
                super.getFavouriteFood(),
                BARK);
    }
}
