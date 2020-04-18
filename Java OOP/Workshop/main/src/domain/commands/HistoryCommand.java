package domain.commands;

import domain.io.Logger;
import domain.repositories.ConversionHistoryRepository;
import domain.commands.inputs.HistoryCommandInput;

import java.util.List;

public class HistoryCommand implements Command<HistoryCommandInput> {
    private final ConversionHistoryRepository repository;
    private final Logger logger;

    public HistoryCommand(ConversionHistoryRepository repository, Logger logger) {
        this.repository = repository;
        this.logger = logger;
    }

    @Override
    public void execute(HistoryCommandInput input) {
        int conversionsToShow = input.getConversionsToShow();
        List<String> lastNConversions = this.repository.getLastNConversions(conversionsToShow);
        lastNConversions.forEach(logger::log);
    }
}
