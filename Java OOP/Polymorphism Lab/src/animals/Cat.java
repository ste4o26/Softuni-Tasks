package animals;

public class Cat extends Animal {
    private static final String MEOW = "MEEOW";

    private String name;
    private String favouriteFood;

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s%n%s",
                super.getName(),
                super.getFavouriteFood(),
                MEOW);
    }
}
