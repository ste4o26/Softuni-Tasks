package car_dealer.domain.dtos;

import car_dealer.domain.entities.Car;
import car_dealer.domain.entities.Customer;
import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CustomerCreateDto {
    @Expose
    private String name;

    @Expose
    private LocalDateTime birthDate;

    @Expose
    private boolean isYoungDriver;

    public CustomerCreateDto() {
    }

    @NotNull(message = "Customer name can not be null!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Birth date can not be null!")
    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    @NotNull(message = "Is young driver field can not be null!")
    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public static class SaleCreateDto {
        private Integer discount;
        private Car car;
        private Customer customer;

        public SaleCreateDto() {
        }

        public Integer getDiscount() {
            return discount;
        }

        public void setDiscount(Integer discount) {
            this.discount = discount;
        }

        public Car getCar() {
            return car;
        }

        public void setCar(Car car) {
            this.car = car;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }
    }
}
