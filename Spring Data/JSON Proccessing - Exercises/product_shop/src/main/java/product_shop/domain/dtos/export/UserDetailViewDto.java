package product_shop.domain.dtos.export;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserDetailViewDto {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Integer age;

    @Expose
    private SoldProductsDetailDto soldProducts;

    public UserDetailViewDto() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SoldProductsDetailDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(SoldProductsDetailDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
