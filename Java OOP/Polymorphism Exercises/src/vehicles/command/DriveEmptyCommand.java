package vehicles.command;

import vehicles.domain.Bus;
import vehicles.domain.VehicleImpl;

public class DriveEmptyCommand extends CommandImpl {

    public DriveEmptyCommand(VehicleImpl vehicle) {
        super(vehicle);
    }

    @Override
    public void execute(double distance) {
        if (this.getVehicle() instanceof Bus) {
            Bus bus = (Bus) getVehicle();
            bus.turnOffAirConditioner();
            bus.driveGivenDistance(distance);
            bus.turnOnAirConditioner();
        }
    }
}
