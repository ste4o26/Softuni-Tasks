package clients.console_client;

import clients.CommandExecutor;
import domain.commands.Command;
import domain.commands.EndCommand;
import domain.commands.HistoryCommand;
import domain.commands.HistorySavingConvertCommand;
import domain.commands.inputs.EndCommandInput;
import domain.commands.inputs.ConvertCommandInput;
import domain.commands.inputs.HistoryCommandInput;
import domain.entities.Money;
import domain.entities.MoneyValidator;
import domain.io.Logger;
import domain.repositories.ConversionHistoryRepository;
import domain.services.ConvertService;

import java.math.BigDecimal;

public class ConsoleCommandExecutor implements CommandExecutor {
    private ConvertService service;
    private Logger logger;
    private ConversionHistoryRepository repository;

    public ConsoleCommandExecutor(ConvertService service, Logger logger, ConversionHistoryRepository repository) {
        this.service = service;
        this.logger = logger;
        this.repository = repository;
    }

    @Override
    public void execute(String[] tokens) {
        String command = tokens[0];
        switch (command) {
            case "CONVERT":
                this.convert(tokens);
                break;

            case "HISTORY":
                this.history(tokens);
                break;

            case "END":
                this.end();
                break;

            default:
                this.logger.log("Invalid command!");
        }

    }

    private void convert(String[] tokens) {
        Money money = generateMoney(tokens);
        validateMoney(money);

        String toCurrency = tokens[3];
        ConvertCommandInput input = new ConvertCommandInput(money, toCurrency);

        Command<ConvertCommandInput> command = new HistorySavingConvertCommand(this.service, this.logger, this.repository);
        command.execute(input);
    }

    private void history(String[] tokens) {
        int conversionsToDisplay = Integer.parseInt(tokens[1]);
        HistoryCommandInput oneFieldInput = new HistoryCommandInput(conversionsToDisplay);
        Command<HistoryCommandInput> command = new HistoryCommand(this.repository, this.logger);
        command.execute(oneFieldInput);
    }

    private void end() {
        EndCommandInput input = new EndCommandInput();
        Command<EndCommandInput> command = new EndCommand();
        command.execute(input);
    }

    private void validateMoney(Money money) {
        MoneyValidator validator = new MoneyValidator(money);
        validator.validate();
    }

    private Money generateMoney(String[] tokens) {
        BigDecimal value = new BigDecimal(tokens[1]);
        String currency = tokens[2];
        return new Money(value, currency);
    }
}
