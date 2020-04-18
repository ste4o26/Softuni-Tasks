package services;

import domain.entities.Money;
import domain.services.ConvertService;

import java.math.BigDecimal;

public class StubbedCurrencyConverter implements ConvertService {

    @Override
    public Money convert(Money fromMoney, String toCurrency) {
        return new Money(BigDecimal.ONE, "USD");
    }
}
