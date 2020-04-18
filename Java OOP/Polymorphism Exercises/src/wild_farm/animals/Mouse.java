package wild_farm.animals;

import wild_farm.foods.Food;

public class Mouse extends Mammal {
    private static final String SOUND = "SQUEEEAAAK!";

    public Mouse(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println(SOUND);
    }

    @Override
    public void eat(Food food) {
        if (food.isFoodVegetable(food)) {
            super.eat(food);
        } else {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
    }
}
