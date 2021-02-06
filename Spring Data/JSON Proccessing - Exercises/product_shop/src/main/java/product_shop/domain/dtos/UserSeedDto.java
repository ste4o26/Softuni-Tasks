package product_shop.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserSeedDto {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Integer age;

    public UserSeedDto() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull(message = "User last name can not be null!")
    @Size(min = 3, message = "User last name must be at least 3 characters long!")
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
}
