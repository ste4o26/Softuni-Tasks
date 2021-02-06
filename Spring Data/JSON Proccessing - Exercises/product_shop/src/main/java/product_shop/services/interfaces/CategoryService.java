package product_shop.services.interfaces;

import product_shop.domain.dtos.CategorySeedDto;
import product_shop.domain.dtos.export.CategoryViewDto;

import java.util.List;

public interface CategoryService {
    String seedCategories(List<CategorySeedDto> categorySeedDtoList);

    List<CategoryViewDto> getCategoriesByProductCount();
}
