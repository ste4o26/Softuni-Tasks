package birthday_selebration.command_manipulator;

import birthday_selebration.Citizen;
import birthday_selebration.repository.Repository;

public class CitizenCommand implements Command{
    private String[] tokens;
    private Repository<Citizen> repository;

    public CitizenCommand(String[] tokens, Repository<Citizen> repository) {
        this.tokens = tokens;
        this.repository = repository;
    }

    @Override
    public void execute(){
        Citizen citizen = createCitizen();
        addCitizenToRepo(citizen);
    }

    private void addCitizenToRepo(Citizen citizen){
        this.repository.add(citizen);
    }

    private Citizen createCitizen(){
        String name = this.tokens[1];
        int age = Integer.parseInt(this.tokens[2]);
        String id = this.tokens[3];
        String birthDate = this.tokens[4];
        return new Citizen(name, age, id, birthDate);
    }
}
