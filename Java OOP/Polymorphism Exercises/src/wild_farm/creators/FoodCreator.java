package wild_farm.creators;

import wild_farm.foods.Food;
import wild_farm.foods.Meat;
import wild_farm.foods.Vegetable;

public class FoodCreator {
    private String[] foodData;

    public FoodCreator(String[] foodData) {
        this.foodData = foodData;
    }

    public Food create(){
        String foodType = foodData[0];
        int foodQuantity = Integer.parseInt(foodData[1]);

        Food food = null;
        if (Vegetable.class.getSimpleName().equals(foodType)){
            food = new Vegetable(foodQuantity);
        }else {
            food = new Meat(foodQuantity);
        }

        return food;
    }
}
