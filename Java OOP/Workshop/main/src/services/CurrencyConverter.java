package services;

import domain.entities.Money;
import domain.services.ConvertService;

import java.math.BigDecimal;


public class CurrencyConverter implements ConvertService {
    private CurrconvExchangeRateAPI exchangeRate;

    public CurrencyConverter() {
        this.exchangeRate = new CurrconvExchangeRateAPI();
    }

    @Override
    public Money convert(Money fromMoney, String toCurrency) {
        BigDecimal exchangeRate = this.exchangeRate.exchange(fromMoney.getCurrency(), toCurrency);
        BigDecimal exchangedMoney = fromMoney
                .getValue()
                .multiply(exchangeRate);

        return new Money(exchangedMoney, toCurrency);
    }
}
