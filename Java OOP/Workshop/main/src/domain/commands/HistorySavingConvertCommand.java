package domain.commands;

import domain.commands.inputs.ConvertCommandInput;
import domain.entities.Money;
import domain.io.Logger;
import domain.repositories.ConversionHistoryRepository;
import domain.services.ConvertService;

public class HistorySavingConvertCommand extends ConvertCommand {
    private ConversionHistoryRepository repository;

    public HistorySavingConvertCommand(ConvertService exchangeService, Logger logger, ConversionHistoryRepository repository) {
        super(exchangeService, logger);
        this.repository = repository;
    }

    @Override
    public void execute(ConvertCommandInput input) {
        Money convertedMoney = super.convertMoney(input);
        super.logConvertedMoney(convertedMoney);
        this.repository.save(input.getMoney(), convertedMoney);
    }
}
