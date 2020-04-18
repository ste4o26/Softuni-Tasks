package barracksWars;

import barracksWars.core.CommandInterpreterImpl;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.UnitFactory;
import barracksWars.core.Engine;
import barracksWars.core.factories.UnitFactoryImpl;
import barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        UnitFactory unitFactory = new UnitFactoryImpl();
        Repository repository = new UnitRepository();

        CommandInterpreterImpl commandInterpreter = new CommandInterpreterImpl(unitFactory, repository);
        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
