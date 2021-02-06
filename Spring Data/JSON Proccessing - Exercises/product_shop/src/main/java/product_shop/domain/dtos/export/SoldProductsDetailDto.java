package product_shop.domain.dtos.export;

import com.google.gson.annotations.Expose;
import product_shop.domain.dtos.ProductViewDto;

import java.util.List;

public class SoldProductsDetailDto {
    @Expose
    private Integer count;

    @Expose
    private List<ProductItemDto> products;

    public SoldProductsDetailDto() {
    }

    public SoldProductsDetailDto(Integer count, List<ProductItemDto> products) {
        this.count = count;
        this.products = products;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ProductItemDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductItemDto> products) {
        this.products = products;
    }
}
