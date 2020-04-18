package wild_farm.animals;

import wild_farm.foods.Food;

public class Tiger extends Felime {
    private static final String SOUND = "ROAAR!!!";

    public Tiger(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if (food.isFoodMeat(food)) {
            super.eat(food);
        }else {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }

    @Override
    public void makeSound() {
        System.out.println(SOUND);
    }

}
