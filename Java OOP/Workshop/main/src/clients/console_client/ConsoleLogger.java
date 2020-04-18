package clients.console_client;

import domain.io.Logger;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String line) {
        System.out.println(line);
    }
}
