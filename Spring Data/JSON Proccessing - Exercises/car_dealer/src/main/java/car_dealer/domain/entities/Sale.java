package car_dealer.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "sales")
@Table(name = "sales")
public class Sale extends BaseEntity {
    private Integer discount;
    private Car car;
    private Customer customer;

    public Sale() {
    }

    public Sale(Integer discount, Car car, Customer customer) {
        this.discount = discount;
        this.car = car;
        this.customer = customer;
    }

    @Column(name = "discount")
    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @NotNull(message = "Sale must have car id!")
    @OneToOne(targetEntity = Car.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @NotNull(message = "Sale must have customer id!")
    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
