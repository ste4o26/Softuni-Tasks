package application.service.interfaces;


import java.util.List;

public interface IngredientService {

    List<String> fetchAllByPrefix(String prefix);

    List<String> fetchAllWithNames(List<String> ingredientsNames);

    Integer deleteIngredientByName(String ingredientName);

    Integer updateAllBy10Percentages();

    Integer updateAllWithNamesIn(List<String> ingredientsNames);
}
