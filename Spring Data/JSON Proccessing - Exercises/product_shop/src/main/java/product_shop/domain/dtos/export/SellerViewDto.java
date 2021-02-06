package product_shop.domain.dtos;

import com.google.gson.annotations.Expose;

public class SellerViewDto {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    public SellerViewDto() {
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

    @Override
    public String toString() {
        return this.firstName == null ?
                this.lastName :
                String.format("%s %s",
                        this.firstName,
                        this.lastName);
    }
}
