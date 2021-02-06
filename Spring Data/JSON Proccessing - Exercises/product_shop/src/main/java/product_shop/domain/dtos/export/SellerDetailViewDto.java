package product_shop.domain.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Set;

public class SellerDetailViewDto {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private List<ProductDetailViewDto> products;

    public SellerDetailViewDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ProductDetailViewDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDetailViewDto> products) {
        this.products = products;
    }
}
