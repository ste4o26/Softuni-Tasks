package vehicles.domain;

public class Car extends VehicleImpl {
    private static final double AIR_CONDITIONER_EXTRA_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_EXTRA_CONSUMPTION, tankCapacity);
    }

    @Override
    public void driveGivenDistance(double distance) {
        System.out.print("Car ");
        super.driveGivenDistance(distance);
    }

    @Override
    public String toString() {
        return String.format("Car: %s", super.toString());
    }
}
