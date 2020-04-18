package vehicles.command;

import vehicles.domain.VehicleImpl;

public class RefuelCommand extends CommandImpl {
    public RefuelCommand(VehicleImpl vehicle) {
        super(vehicle);
    }

    @Override
    public void execute(double litters) {
        VehicleImpl vehicle = getVehicle();
        vehicle.refuelWithGivenLitters(litters);
    }
}
