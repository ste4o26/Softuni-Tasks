package domain.commands.inputs;

import domain.entities.Money;

public class ConvertCommandInput extends AbstractInput{
    private final Money money;
    private final String toCurrency;

    public ConvertCommandInput(Money money, String toCurrency) {
        this.money = money;
        this.toCurrency = toCurrency;
    }

    public Money getMoney() {
        return money;
    }

    public String getToCurrency() {
        return toCurrency;
    }
}
