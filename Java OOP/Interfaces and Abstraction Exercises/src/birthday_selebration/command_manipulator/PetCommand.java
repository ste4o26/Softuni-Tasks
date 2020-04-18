package birthday_selebration.command_manipulator;

import birthday_selebration.Pet;
import birthday_selebration.repository.Repository;

public class PetCommand implements Command {
    private String[] tokens;
    private Repository<Pet> repository;

    public PetCommand(String[] tokens, Repository<Pet> repository) {
        this.tokens = tokens;
        this.repository = repository;
    }

    @Override
    public void execute() {
        Pet pet = createPet();
        addPetToRepository(pet);
    }

    private void addPetToRepository(Pet pet) {
        this.repository.add(pet);
    }

    private Pet createPet() {
        String name = this.tokens[1];
        String birthDate = this.tokens[2];
        return new Pet(name, birthDate);
    }
}
