package domain.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MoneyValidator {
    private Money money;

    public MoneyValidator(Money money) {
        this.money = money;
    }

    public void validate(){
        BigDecimal value = this.money.getValue();
        String currency = this.money.getCurrency();
        List<String> invalidFields = new ArrayList<>();

        if (value == null || isValueZero()){
            invalidFields.add("value must be not null and negative number");
        }
        if (currency == null || currency.length() != 3){
            invalidFields.add("currency must be not null and must contains exactly 3 letters");
        }

        if (!invalidFields.isEmpty()){
            throw new IllegalArgumentException("Invalid fields: " + invalidFields);
        }
    }

    private boolean isValueZero() {
        return this.money
                .getValue()
                .compareTo(BigDecimal.ZERO) <= 0;
    }
}
