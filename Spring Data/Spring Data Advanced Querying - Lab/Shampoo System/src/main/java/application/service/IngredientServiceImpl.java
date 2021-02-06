package application.service;

import application.domain.entities.Ingredient;
import application.repository.IngredientRepository;
import application.service.interfaces.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> fetchAllByPrefix(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix is required!");
        }

        List<Ingredient> ingredients = this.ingredientRepository
                .fetchByNameStartsWith(prefix);

        return this.mapIngredientsToStrings(ingredients);
    }

    @Override
    public List<String> fetchAllWithNames(List<String> ingredientsNames) {
        if (ingredientsNames.isEmpty()) {
            throw new IllegalArgumentException("At least one ingredient name is required!");
        }

        List<Ingredient> ingredients = this.ingredientRepository
                .fetchWithNamesOrderByPrice(ingredientsNames);

        return this.mapIngredientsToStrings(ingredients);
    }

    @Transactional
    @Override
    public Integer deleteIngredientByName(String ingredientName) {
        if (ingredientName == null || ingredientName.trim().equals("")) {
            throw new IllegalArgumentException("Ingredient name can not be null or empty!");
        }

        return this.ingredientRepository
                .deleteByName(ingredientName);
    }

    @Transactional
    @Override
    public Integer updateAllBy10Percentages() {
        return this.ingredientRepository
                .updateAllPricesBy10Percentages();
    }

    @Transactional
    @Override
    public Integer updateAllWithNamesIn(List<String> ingredientsNames) {
        //TODO think of some kind of validations!!!

        return this.ingredientRepository
                .updateAllWithNameIn(ingredientsNames);
    }

    private List<String> mapIngredientsToStrings(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }
}
