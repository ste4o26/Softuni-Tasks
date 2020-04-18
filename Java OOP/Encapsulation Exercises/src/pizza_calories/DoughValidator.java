package pizza_calories;

public class DoughValidator {

    public static void validateFlourType(String flourType) {
        if (!isValidFlourType(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private static boolean isValidFlourType(String flourType) {
        FlourTypes[] flours = FlourTypes.values();
        for (FlourTypes flour : flours) {
            if (flour.name().equals(flourType)) {
                return true;
            }
        }
        return false;
    }

    public static void validateBakingTechnique(String bakingTechnique) {
        if (!isValidBakingTechnique(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private static boolean isValidBakingTechnique(String bakingTechnique) {
        BakingTechniques[] techniques = BakingTechniques.values();
        for (BakingTechniques technique : techniques) {
            if (technique.name().equals(bakingTechnique)){
                return true;
            }
        }
        return false;
    }

    public static void validateDoughWeight(double weight){
        if (!isValidDoughWeight(weight)){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    private static boolean isValidDoughWeight(double weight) {
        return weight >= 1 && weight <= 200;
    }


}
