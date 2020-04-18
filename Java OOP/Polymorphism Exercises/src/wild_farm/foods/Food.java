package wild_farm.foods;

public abstract class Food {
    private int foodQuantity;

    protected Food(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public int getFoodQuantity() {
        return this.foodQuantity;
    }

    public boolean isFoodVegetable(Food food) {
        return food
                .getClass()
                .getSimpleName()
                .equals("Vegetable");
    }

    public boolean isFoodMeat(Food food){
        return food
                .getClass()
                .getSimpleName()
                .equals("Meat");
    }
}
