package application.service;

import application.domain.entities.Ingredient;
import application.domain.entities.Shampoo;
import application.domain.entities.Size;
import application.repository.IngredientRepository;
import application.repository.ShampooRepository;
import application.repository.LabelRepository;
import application.service.interfaces.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * When using another repository into the service like in this case labelRepository ...
 * DONT FORGET TO INJECT IT VIA CONSTRUCTOR!!! OR ELSE NULL POINTER EXCEPTION
 */

@Service
public class ShampooServiceImpl implements ShampooService {
    private ShampooRepository shampooRepository;
    private LabelRepository labelRepository;
    private IngredientRepository ingredientRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository,
                              LabelRepository labelRepository,
                              IngredientRepository ingredientRepository) {
        this.shampooRepository = shampooRepository;
        this.labelRepository = labelRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> fetchAllBySize(String sizeAsString) {
        Arrays.stream(Size.values())
                .filter(size -> size.name().equals(sizeAsString))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Size %s does not exists!", sizeAsString)));

        Size size = Size.valueOf(sizeAsString.toUpperCase());

        List<Shampoo> shampoos = this.shampooRepository
                .fetchAllBySize(size);

        return this.mapShampoosToStrings(shampoos);
    }

    @Override
    public List<String> fetchAllBySizeOrLabelId(String sizeAsString, Long labelId) {
        Size size = Arrays.stream(Size.values())
                .filter(s -> s.name().equals(sizeAsString))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Size %s does not exists!", sizeAsString)));

        this.labelRepository
                .findById(labelId)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Label with %d id does not exists!", labelId)));

        List<Shampoo> shampoos = this.shampooRepository
                .fetchAllBySizeOrLabelIdOrderByPrice(size, labelId);

        return this.mapShampoosToStrings(shampoos);
    }

    @Override
    public List<String> fetchAllByPrice(String priceAsString) {
        BigDecimal price = new BigDecimal(priceAsString);
        List<Shampoo> shampoos = this.shampooRepository
                .fetchAllByPrice(price);

        return this.mapShampoosToStrings(shampoos);
    }

    @Override
    public List<String> fetchALlByIngredients(List<String> ingredientsNames) {
        List<Ingredient> ingredients = this.ingredientRepository
                .fetchWithNamesOrderByPrice(ingredientsNames);

        if (ingredients.isEmpty()) {
            throw new IllegalArgumentException("At least one ingredient should present!");
        }

        List<Shampoo> shampoos = this.shampooRepository
                .fetchShampoosByIngredients(ingredients);

        return this.mapShampoosToBrandsAsString(shampoos);
    }

    @Override
    public Integer fetchCountByPriceLowerThan(String priceAsString) {
        if (priceAsString == null || priceAsString.trim().equals("")) {
            throw new IllegalArgumentException("Price is required!");
        }

        BigDecimal price = new BigDecimal(priceAsString);
        return this.shampooRepository
                .countByPrice(price);
    }

    @Override
    public List<String> fetchAllByIngredientsCount(Integer ingredientsCount) {
        if (ingredientsCount == null || ingredientsCount == 0 || ingredientsCount == 1) {
            throw new IllegalArgumentException("Ingredients count can not be null, 0 or 1!");
        }

        List<Shampoo> shampoos = this.shampooRepository
                .fetchAllByIngredientsCountLowerThan(ingredientsCount);

        return this.mapShampoosToBrandsAsString(shampoos);


    }

    @Override
    public BigDecimal fetchIngredientsPriceSumByBrand(String shampooBrand) {
        if (shampooBrand == null || shampooBrand.trim().equals("")) {
            throw new IllegalArgumentException("Brand cannot be null or empty!");
        }

        return this.shampooRepository
                .fetchIngredientsPriceSumByName(shampooBrand.trim());
    }

    private List<String> mapShampoosToStrings(List<Shampoo> shampoos) {
        return shampoos.stream()
                .map(shampoo -> String.format("%s %s %.2flv", shampoo.getBrand(),
                        shampoo.getSize().name(),
                        shampoo.getPrice()))
                .collect(Collectors.toList());
    }

    private List<String> mapShampoosToBrandsAsString(List<Shampoo> shampoos) {
        return shampoos.stream()
                .map(Shampoo::getBrand)
                .collect(Collectors.toList());
    }
}


