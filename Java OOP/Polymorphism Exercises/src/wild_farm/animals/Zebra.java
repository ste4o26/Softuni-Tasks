package wild_farm.animals;

import wild_farm.foods.Food;

public class Zebra extends Mammal {
    private static final String SOUND = "Zs";

    public Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if (food.isFoodVegetable(food)) {
            super.eat(food);
        } else {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
    }

    @Override
    public void makeSound() {
        System.out.println(SOUND);
    }


}
