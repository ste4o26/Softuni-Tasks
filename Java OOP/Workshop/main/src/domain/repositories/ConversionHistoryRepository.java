package domain.repositories;

import domain.entities.Money;

import java.util.List;

public interface ConversionHistoryRepository {
    List<String> getLastNConversions(int conversionsToGet);

    void save(Money money, Money convertedMoney);
}
