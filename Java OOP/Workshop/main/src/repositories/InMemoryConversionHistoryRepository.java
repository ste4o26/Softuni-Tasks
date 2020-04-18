package repositories;

import domain.entities.Money;
import domain.repositories.ConversionHistoryRepository;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryConversionHistoryRepository implements ConversionHistoryRepository {
    private Deque<String> history;

    public InMemoryConversionHistoryRepository() {
        history = new ArrayDeque<>();
    }

    @Override
    public List<String> getLastNConversions(int conversionsToGet) {
        return history
                .stream()
                .limit(conversionsToGet)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Money money, Money convertedMoney) {
        String conversionMessage = createConversionMessage(money, convertedMoney);
        history.push(conversionMessage);
    }

    private String createConversionMessage(Money money, Money convertedMoney) {
        return String.format("Money converted from: %s to: %s",
                money.toString(),
                convertedMoney.toString());
    }
}
