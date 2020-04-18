package barracksWars.core.commands;

import barracksWars.interfaces.Injectable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;

public class AddCommand extends Command {
    @Injectable
    private String[] data;
    @Injectable
    private UnitFactory unitFactory;
    @Injectable
    private Repository repository;

    public AddCommand(){

    }

    @Override
    public String execute() {
        String unitType = this.data[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
