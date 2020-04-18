package pizza_calories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private String getFlourType() {
        return this.flourType;
    }

    private void setFlourType(String flourType) {
        DoughValidator.validateFlourType(flourType);
        this.flourType = flourType;
    }

    private String getBakingTechnique() {
        return this.bakingTechnique;
    }

    private void setBakingTechnique(String bakingTechnique) {
        DoughValidator.validateBakingTechnique(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private double getWeight() {
        return this.weight;
    }

    private void setWeight(double weight) {
        DoughValidator.validateDoughWeight(weight);
        this.weight = weight;
    }

    public double calculateCalories() {
        String flourType = getFlourType();
        double flourTypeModifier = FlourTypes
                .valueOf(flourType)
                .getModifier();

        String bakingTechnique = getBakingTechnique();
        double bakingTechniqueModifier = BakingTechniques
                .valueOf(bakingTechnique)
                .getModifier();

        double weight = getWeight();

        return (2 * weight) * flourTypeModifier * bakingTechniqueModifier;
    }
}
