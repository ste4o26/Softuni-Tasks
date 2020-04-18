package vehicles.domain;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private static final DecimalFormat FORMATTER = new DecimalFormat("##.##");//premahva vodeshtitte nuli
    // sled desetichanta zapetaq v double i float chisla

    private double fuelQuantity;
    private double fuelConsumption; //in liters Per Km
    private double tankCapacity;

    public VehicleImpl(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }



    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        VehicleValidator.validateLitters(fuelQuantity, this.getTankCapacity());
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected void decreaseFuelQuantity(double distance){
        double decreasedFuelQuantity = this.getFuelQuantity() - getTotalLittersNeeded(distance);
        this.setFuelQuantity(decreasedFuelQuantity);
    }

    protected boolean hasEnoughFuelToDrive(double distance) {
        return getFuelQuantity() >= getTotalLittersNeeded(distance);
    }

    private double getTotalLittersNeeded(double distance){
        return getFuelConsumption() * distance;
    }

    public void driveGivenDistance(double distance){
        if (hasEnoughFuelToDrive(distance)) {
            decreaseFuelQuantity(distance);
            System.out.println(String.format("travelled %s km", FORMATTER.format(distance)));
        } else {
            System.out.println("needs refueling");
        }
    }

    public void refuelWithGivenLitters(double litters){
        VehicleValidator.validateLitters(litters, this.getTankCapacity());
        double refueledQuantity = getFuelQuantity() + litters;
        setFuelQuantity(refueledQuantity);
    }

    @Override
    public String toString() {
        return String.format("%.2f", getFuelQuantity());
    }
}
