package domain.services;

import domain.entities.Money;

public interface ConvertService {

    Money convert(Money fromMoney, String toCurrency);
}
