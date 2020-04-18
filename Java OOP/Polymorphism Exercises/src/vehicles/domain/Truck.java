package vehicles.domain;

public class Truck extends VehicleImpl {
    private static final double AIR_CONDITIONER_EXTRA_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_EXTRA_CONSUMPTION, tankCapacity);
    }

    @Override
    public void driveGivenDistance(double distance) {
        System.out.print("Truck ");
        super.driveGivenDistance(distance);
    }

    @Override
    public void refuelWithGivenLitters(double litters) {
        litters *= 0.95;
        super.refuelWithGivenLitters(litters);
    }

    @Override
    public String toString() {
        return String.format("Truck: %s", super.toString());
    }
}
