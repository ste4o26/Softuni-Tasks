package domain.commands;

import domain.commands.inputs.ConvertCommandInput;
import domain.entities.Money;
import domain.services.ConvertService;
import domain.io.Logger;

public class ConvertCommand implements Command<ConvertCommandInput> {

    private final ConvertService convertService;
    private final Logger logger;

    public ConvertCommand(ConvertService convert, Logger logger) {
        this.convertService = convert;
        this.logger = logger;
    }

    @Override
    public void execute(ConvertCommandInput input) {
        Money convertedMoney = convertMoney(input);
        logConvertedMoney(convertedMoney);
    }

    protected Money convertMoney(ConvertCommandInput input) {
        return convertService.convert(input.getMoney(), input.getToCurrency());
    }

    protected void logConvertedMoney(Money convertedMoney) {
        this.logger.log("Successful conversion: " + convertedMoney.toString());
    }
}
