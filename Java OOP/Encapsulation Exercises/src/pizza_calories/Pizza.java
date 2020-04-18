package pizza_calories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings){
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        PizzaValidator.validatePizzaName(name);
        this.name = name;
    }

    private Dough getDough() {
        return this.dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private List<Topping> getToppings() {
        return Collections.unmodifiableList(this.toppings);
    }

    private void setToppings(int numberOfToppings) {
        PizzaValidator.validateNumberOfToppings(numberOfToppings);
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double totalToppingsCalories = 0.0;
        List<Topping> toppings = getToppings();
        for (Topping topping : toppings) {
            double toppingCalories = topping.calculateCalories();
            totalToppingsCalories += toppingCalories;
        }

        double doughCalories = getDough().calculateCalories();
        totalToppingsCalories += doughCalories;

        return totalToppingsCalories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f",
                this.getName(),
                this.getOverallCalories());
    }
}
