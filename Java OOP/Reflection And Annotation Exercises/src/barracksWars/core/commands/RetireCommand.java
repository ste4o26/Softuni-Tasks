package barracksWars.core.commands;

import barracksWars.interfaces.Injectable;
import barracksWars.interfaces.Repository;

public class RetireCommand extends Command{
    @Injectable
    private String[] data;
    @Injectable
    private Repository repository;

    public RetireCommand() {
    }

    @Override
    public String execute() {
        String unitType = this.data[1];
        try {
            this.repository.removeUnit(unitType);
            return unitType + " retired!";
        }catch (IllegalArgumentException iae){
            return iae.getMessage();
        }
    }
}
