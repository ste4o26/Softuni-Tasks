package com.spirng_demo.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "account")
@Table(name = "accounts")
public class Account extends BaseEntity {
    private BigDecimal balance;
    private User user;

    public Account() {
    }

    @Column(name = "balance")
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
