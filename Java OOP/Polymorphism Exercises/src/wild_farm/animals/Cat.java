package wild_farm.animals;

import wild_farm.foods.Food;

public class Cat extends Felime {
    private static final String SOUND = "Meowwww";

    private String catBreed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String catBreed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.catBreed = catBreed;
    }

    @Override
    public void makeSound() {
        System.out.println(SOUND);
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]",this.getAnimalType(),
                this.getAnimalName(),
                this.catBreed,
                FORMATTER.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
