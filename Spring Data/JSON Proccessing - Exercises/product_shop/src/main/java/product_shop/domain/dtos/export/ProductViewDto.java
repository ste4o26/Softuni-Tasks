package product_shop.domain.dtos;

import com.google.gson.annotations.Expose;
import product_shop.domain.entities.User;

import java.math.BigDecimal;

public class ProductViewDto {
    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    private String seller;

    public ProductViewDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
