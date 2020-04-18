package wild_farm.animals;

import wild_farm.foods.Food;

import java.text.DecimalFormat;

public abstract class Mammal extends AnimalImpl {
    protected static final DecimalFormat FORMATTER = new DecimalFormat("#.##");//premahva vodeshtitte nuli

    private String livingRegion;

    public Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return this.livingRegion;
    }

    @Override
    public String toString() {

        return String.format("%s[%s, %s, %s, %d]",this.getAnimalType(),
                this.getAnimalName(),
                FORMATTER.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}

