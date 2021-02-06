package product_shop.services.interfaces;

import product_shop.domain.dtos.ProductSeedDto;
import product_shop.domain.dtos.ProductViewDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    String seedProducts(List<ProductSeedDto> productSeedDtoList);

    void addRandomCategoriesToAllProducts();

    List<ProductViewDto> getProductsInRange(BigDecimal from, BigDecimal to);
}
