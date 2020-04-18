package food_shortage.command_manipulator;

import food_shortage.Buyer;
import food_shortage.Citizen;

import java.util.Map;

public class CitizenCommand implements Command {
    private String[] tokens;
    private Map<String, Buyer> repository;

    public CitizenCommand(String[] tokens, Map<String, Buyer> repository) {
        this.tokens = tokens;
        this.repository = repository;
    }

    @Override
    public void execute() {
        Citizen citizen = createCitizen();
        addCitizenToRepository(citizen);
    }

    private void addCitizenToRepository(Citizen citizen) {
        String name = citizen.getName();
        this.repository.putIfAbsent(name, citizen);
    }

    private Citizen createCitizen() {
        String name = this.tokens[0];
        int age = Integer.parseInt(this.tokens[1]);
        String id = this.tokens[2];
        String birthDate = this.tokens[3];
        return new Citizen(name, age, id, birthDate);
    }
}
