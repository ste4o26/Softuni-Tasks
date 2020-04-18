package food_shortage.command_manipulator;

import food_shortage.Buyer;
import food_shortage.Rebel;

import java.util.Map;

public class RebelCommand implements Command {
    private String[] tokens;
    private Map<String, Buyer> repository;

    public RebelCommand(String[] tokens, Map<String, Buyer> repository) {
        this.tokens = tokens;
        this.repository = repository;
    }


    @Override
    public void execute() {
        Rebel rebel = createRebel();
        addRebelToRepository(rebel);
    }

    private void addRebelToRepository(Rebel rebel) {
        String name = rebel.getName();
        this.repository.putIfAbsent(name, rebel);
    }

    private Rebel createRebel() {
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        String group = tokens[2];
        return new Rebel(name, age, group);
    }
}
