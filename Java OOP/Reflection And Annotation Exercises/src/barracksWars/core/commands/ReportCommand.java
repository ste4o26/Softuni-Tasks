package barracksWars.core.commands;

import barracksWars.interfaces.Injectable;
import barracksWars.interfaces.Repository;

public class ReportCommand extends Command {
    @Injectable
    private Repository repository;

    public ReportCommand() {
    }

    @Override
    public String execute() {
        String output = this.repository.getStatistics();
        return output;
    }
}
