package product_shop.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductSeedDto {
    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    public ProductSeedDto() {
    }

    @NotNull(message = "Product name can not be null!")
    @Size(min = 3, message = "Product name must be at least 3 characters long!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Product price can not be null!")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
