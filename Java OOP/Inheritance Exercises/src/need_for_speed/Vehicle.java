package need_for_speed;

public class Vehicle {
    public static final double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return this.fuel;
    }

    public int getHorsePower() {
        return this.horsePower;
    }


    public void drive(double kilometers) {
        double neededFuel = getFuelConsumption() * kilometers;
        if (hasEnoughFuelToDrive(neededFuel)) {
            double fuel = getFuel();
            fuel -= neededFuel;
            this.fuel = fuel;
        }
    }

    private boolean hasEnoughFuelToDrive(double neededFuel) {
        return  getFuel() >= neededFuel;
    }
}
