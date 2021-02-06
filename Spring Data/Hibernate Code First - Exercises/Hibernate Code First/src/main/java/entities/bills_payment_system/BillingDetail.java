package entities.bills_payment_system;

import javax.persistence.*;

@Entity(name = "billing_details")
@Table(name = "billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
public class BillingDetail extends BaseEntity{
    private String number;
    private User user;

    public BillingDetail() {
    }

    @Column(name = "number", length = 20)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User owner) {
        this.user = owner;
    }
}
