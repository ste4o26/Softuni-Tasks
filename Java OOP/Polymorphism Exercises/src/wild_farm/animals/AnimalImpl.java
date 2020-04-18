package wild_farm.animals;

import wild_farm.foods.Food;

public abstract class AnimalImpl implements Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    protected AnimalImpl(String animalName, String animalType, double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public String getAnimalType() {
        return this.animalType;
    }

    public String getAnimalName() {
        return this.animalName;
    }

    public double getAnimalWeight() {
        return this.animalWeight;
    }

    public int getFoodEaten() {
        return this.foodEaten;
    }

    @Override
    public void eat(Food food) {
        this.foodEaten += food.getFoodQuantity();
    }
}
