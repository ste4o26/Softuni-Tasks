package vehicles.command;

import vehicles.domain.VehicleImpl;

import java.util.Map;

public class CommandExecutor {
    private String[] tokens;
    private Map<String, VehicleImpl> vehicles;

    public CommandExecutor(String[] tokens, Map<String, VehicleImpl> vehicles) {
        this.tokens = tokens;
        this.vehicles = vehicles;
    }

    private VehicleImpl getVehicle(String vehicleType) {
        return this.vehicles.get(vehicleType);
    }

    public void executeCommand() {
        String commandAsString = tokens[0];
        String vehicleType = tokens[1];
        double value = Double.parseDouble(tokens[2]);

        CommandImpl command = null;
        switch (commandAsString) {
            case "Drive":
                command = new DriveCommand(this.getVehicle(vehicleType));
                break;

            case "Refuel":
                command = new RefuelCommand(this.getVehicle(vehicleType));
                break;

            case "DriveEmpty":
                command = new DriveEmptyCommand(this.getVehicle(vehicleType));
                break;
        }

        if (command != null) {
            try {
                command.execute(value);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}
