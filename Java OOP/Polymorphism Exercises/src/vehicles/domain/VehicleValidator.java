package vehicles.domain;

public class VehicleValidator {


    private static void isFuelQuantityBellowZero(double fuelQuantity) {
        if (fuelQuantity <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }

    public static void validateLitters(double fuelQuantity, double tankCapacity){
       isFuelQuantityBellowZero(fuelQuantity);
       isRefuelQuantityMoreThenTankCapacity(fuelQuantity, tankCapacity);
    }

    private static void isRefuelQuantityMoreThenTankCapacity(double refuelQuantity, double tankCapacity){
        if (refuelQuantity > tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }
}
