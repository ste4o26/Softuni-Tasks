package vehicles.command;

import vehicles.domain.VehicleImpl;

public class DriveCommand extends CommandImpl {

    public DriveCommand(VehicleImpl vehicle) {
        super(vehicle);
    }

    @Override
    public void execute(double distance) {
        VehicleImpl vehicle = this.getVehicle();
        vehicle.driveGivenDistance(distance);
    }
}
