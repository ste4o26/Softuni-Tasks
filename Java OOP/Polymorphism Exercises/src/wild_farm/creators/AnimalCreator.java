package wild_farm.creators;

import wild_farm.animals.*;

public class AnimalCreator {
    private String[] animalData;

    public AnimalCreator(String[] animalData) {
        this.animalData = animalData;
    }

    public AnimalImpl create() {
        String animalType = this.animalData[0];
        String animalName = this.animalData[1];
        double animalWeight = Double.parseDouble(this.animalData[2]);
        String animalLivingRegion = this.animalData[3];

        AnimalImpl animal = null;
        switch (animalType) {
            case "Mouse":
                animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                break;

            case "Tiger":
                animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                break;

            case "Cat":
                String catBreed = animalData[4];
                animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);
                break;

            case "Zebra":
                animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                break;
        }

        return animal;
    }
}
