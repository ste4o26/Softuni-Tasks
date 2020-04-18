package wild_farm;

import wild_farm.animals.AnimalImpl;
import wild_farm.creators.AnimalCreator;
import wild_farm.creators.FoodCreator;
import wild_farm.foods.Food;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String END = "End";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<AnimalImpl> animals = new ArrayList<>();

        String inputLine = reader.readLine();
        while (!END.equals(inputLine)) {
            String[] animalData = inputLine.split("\\s+");
            String[] foodData = reader.readLine().split("\\s+");

            FoodCreator foodCreator = new FoodCreator(foodData);
            Food food = foodCreator.create();

            AnimalCreator animalCreator = new AnimalCreator(animalData);
            AnimalImpl animal = animalCreator.create();

            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

            animals.add(animal);

            inputLine = reader.readLine();
        }

        animals.forEach(animal -> System.out.println(animal.toString()));
    }
}
