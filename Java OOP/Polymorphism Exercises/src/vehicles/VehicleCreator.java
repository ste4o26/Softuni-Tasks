package vehicles;

import vehicles.domain.Bus;
import vehicles.domain.Car;
import vehicles.domain.Truck;
import vehicles.domain.VehicleImpl;

public class VehicleCreator {
    private String[] tokens;

    public VehicleCreator(String[] tokens) {
        this.tokens = tokens;
    }

    public VehicleImpl createVehicleFromData() {
        String vehicleType = this.tokens[0];
        double fuelQuantity = Double.parseDouble(this.tokens[1]);
        double fuelConsumption = Double.parseDouble(this.tokens[2]);
        double tankCapacity = Double.parseDouble(this.tokens[3]);

        VehicleImpl vehicle = null;
        switch (vehicleType) {
            case "Car":
                vehicle = new Car(fuelQuantity, fuelConsumption, tankCapacity);
                break;

            case "Truck":
                vehicle = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
                break;

            case "Bus":
                vehicle = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
        }

        return vehicle;
    }
}
