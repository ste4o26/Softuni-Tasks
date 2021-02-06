package product_shop.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategorySeedDto {
    @Expose
    private String name;

    public CategorySeedDto() {
    }

    @NotNull(message = "Category name can not be null!")
    @Size(min = 3, max = 15, message = "Product name must be between 3 and 15 characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
