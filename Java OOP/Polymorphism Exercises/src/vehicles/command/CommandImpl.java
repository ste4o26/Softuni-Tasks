package vehicles.command;

import vehicles.domain.VehicleImpl;

public abstract class CommandImpl implements Command {

    private VehicleImpl vehicle;

    public CommandImpl(VehicleImpl vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleImpl getVehicle() {
        return this.vehicle;
    }
}
