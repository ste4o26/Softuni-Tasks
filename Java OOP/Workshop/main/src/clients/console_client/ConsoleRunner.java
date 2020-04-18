package clients.console_client;

import clients.CommandExecutor;
import clients.Runner;
import domain.repositories.ConversionHistoryRepository;
import domain.services.ConvertService;
import domain.io.Logger;
import services.CurrencyConverter;
import repositories.InMemoryConversionHistoryRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleRunner implements Runner {
    private ConvertService service;
    private Logger logger;
    private ConversionHistoryRepository repository;

    public ConsoleRunner() {
        this.service = new CurrencyConverter();
        this.logger = new ConsoleLogger();
        this.repository = new InMemoryConversionHistoryRepository();
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String inputLine = null;

            try {
                inputLine = reader.readLine();
            } catch (IOException e) {
                this.logger.log("Data was not read properly!");
                return;
            }

            String[] tokens = inputLine.split("\\s+");

            CommandExecutor executor = new ConsoleCommandExecutor(this.service, this.logger, this.repository);
            try {
                executor.execute(tokens);
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }

        }
    }
}
