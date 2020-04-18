package vehicles.domain;

public class Bus extends VehicleImpl {
    private static final double AIR_CONDITIONER_EXTRA_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_EXTRA_CONSUMPTION, tankCapacity);
    }

    @Override
    public void driveGivenDistance(double distance) {
        System.out.print("Bus ");
        super.driveGivenDistance(distance);
    }

    @Override
    public String toString() {
        return String.format("Bus: %s", super.toString());
    }

    public void turnOffAirConditioner(){
        super.setFuelConsumption(this.getFuelConsumption() - AIR_CONDITIONER_EXTRA_CONSUMPTION);
    }

    public void turnOnAirConditioner(){
        super.setFuelConsumption(this.getFuelConsumption() + AIR_CONDITIONER_EXTRA_CONSUMPTION);
    }
}
