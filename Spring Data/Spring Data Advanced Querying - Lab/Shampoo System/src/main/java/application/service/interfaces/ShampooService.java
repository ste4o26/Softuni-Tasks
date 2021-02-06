package application.service.interfaces;

import application.domain.entities.Shampoo;
import application.domain.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {

    List<String> fetchAllBySize(String sizeAsString);

    List<String> fetchAllBySizeOrLabelId(String sizeAsString, Long labelId);

    List<String> fetchAllByPrice(String priceAsString);

    List<String> fetchALlByIngredients(List<String> ingredientsNames);

    Integer fetchCountByPriceLowerThan(String priceAsString);

    List<String> fetchAllByIngredientsCount(Integer ingredientsCount);

    BigDecimal fetchIngredientsPriceSumByBrand(String shampooBrand);
}
