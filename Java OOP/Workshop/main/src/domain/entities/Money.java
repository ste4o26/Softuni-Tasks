package domain.entities;

import java.math.BigDecimal;

public class Money {
    private final BigDecimal value;
    private final String currency;

    public Money(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public String getCurrency() {
        return this.currency;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getValue(), this.getCurrency());
    }
}
