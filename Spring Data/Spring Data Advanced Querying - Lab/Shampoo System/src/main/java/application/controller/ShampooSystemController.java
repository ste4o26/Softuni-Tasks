package application.controller;

import application.service.interfaces.IngredientService;
import application.service.interfaces.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ShampooSystemController implements CommandLineRunner {
    private ShampooService shampooService;
    private IngredientService ingredientService;

    @Autowired
    public ShampooSystemController(ShampooService shampooService,
                                   IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) {
        try {
//            this.selectShampoosBySize();
//            this.selectShampoosBySizeOrLabel();
//            this.selectShampoosByPrice();
//            this.selectIngredientsByName();
//            this.selectIngredientsByNames();
//            this.selectShampoosByIngredients();
//            this.countShampoosByPrice();
//            this.selectShampoosByIngredientsCount();
//            this.selectIngredientNameAndShampooBrandByName();
//            this.deleteIngredientsByName();
//            this.updateIngredientsByPrice();
            this.updateIngredientsByNames();
        } catch (IOException | IllegalArgumentException e) {
            System.err.println(String.format("%s with message: %s",
                    e.getClass().getSimpleName(),
                    e.getMessage()));
        }
    }

    /**
     * 1st Task
     */
    private void selectShampoosBySize() throws IOException, IllegalArgumentException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter size: ");
        String sizeAsString = reader.readLine();

        this.shampooService
                .fetchAllBySize(sizeAsString)
                .forEach(System.out::println);
    }

    /**
     * 2nd Task
     */
    private void selectShampoosBySizeOrLabel() throws IOException, IllegalArgumentException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter size: ");
        String sizeAsString = reader.readLine();

        System.out.print("Enter label id: ");
        Long labelId = Long.parseLong(reader.readLine());


        this.shampooService
                .fetchAllBySizeOrLabelId(sizeAsString, labelId)
                .forEach(System.out::println);

    }

    /**
     * 3rd Task
     */
    private void selectShampoosByPrice() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter price: ");
        String priceAsString = reader.readLine();

        this.shampooService
                .fetchAllByPrice(priceAsString)
                .forEach(System.out::println);
    }

    /**
     * 4th Task
     */
    private void selectIngredientsByName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter prefix: ");
        String prefix = reader.readLine();

        this.ingredientService
                .fetchAllByPrefix(prefix)
                .forEach(System.out::println);
    }

    /**
     * 5th Task
     */
    private void selectIngredientsByNames() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //SEPARATED WITH SPACE NOT WITH NEW LINES!!!
        System.out.print("Enter ingredients names: ");
        List<String> ingredientsNames = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        this.ingredientService
                .fetchAllWithNames(ingredientsNames)
                .forEach(System.out::println);
    }

    /**
     * 6th Task
     */
    private void countShampoosByPrice() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter price: ");
        String priceAsString = reader.readLine();

        Integer shampooCount = this.shampooService
                .fetchCountByPriceLowerThan(priceAsString);

        System.out.println(shampooCount);
    }

    /**
     * 7th Task
     */
    private void selectShampoosByIngredients() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //SEPARATED BY SPACE ONLY!!!
        System.out.print("Enter ingredients names: ");
        List<String> ingredientsNames = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        this.shampooService
                .fetchALlByIngredients(ingredientsNames)
                .forEach(System.out::println);
    }

    /**
     * 8th Task
     */
    private void selectShampoosByIngredientsCount() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter ingredients count: ");
        Integer ingredientsCount = Integer.parseInt(reader.readLine());

        this.shampooService
                .fetchAllByIngredientsCount(ingredientsCount)
                .forEach(System.out::println);
    }

    /**
     * 9th Task
     */
    private void selectIngredientNameAndShampooBrandByName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter shampoo brand: ");
        String shampooBrand = reader.readLine();

        BigDecimal totalIngredientsPrice = this.shampooService
                .fetchIngredientsPriceSumByBrand(shampooBrand);

        System.out.println(totalIngredientsPrice);
    }

    /**
     * 10th Task
     */
    private void deleteIngredientsByName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter ingredient name: ");
        String ingredientName = reader.readLine();

        Integer affectedRows = this.ingredientService
                .deleteIngredientByName(ingredientName);

        if (affectedRows > 0) {
            System.out.println("Ingredient deleted successfully.");
        }
    }

    /**
     * 11th Task
     */
    private void updateIngredientsByPrice() throws IOException{
        Integer affectedRows = this.ingredientService
                .updateAllBy10Percentages();

        System.out.printf("%d ingredients updated.%n", affectedRows);
    }

    /**
     * 12th Task
     */
    private void updateIngredientsByNames() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //SEPARATED BY SPACE ONLY!!!
        System.out.print("Enter ingredients name: ");
        List<String> ingredientsNames = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        Integer rowsAffected = this.ingredientService
                .updateAllWithNamesIn(ingredientsNames);

        System.out.printf("%d ingredients updated.%n", rowsAffected);
    }
}
