package vehicles;

import vehicles.command.*;
import vehicles.domain.VehicleImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, VehicleImpl> vehicles = new LinkedHashMap<>();


        VehicleCreator vehicleParser = new VehicleCreator(parseVehicleData(reader));
        vehicles.put("Car", vehicleParser.createVehicleFromData());

        vehicleParser = new VehicleCreator(parseVehicleData(reader));
        vehicles.put("Truck", vehicleParser.createVehicleFromData());

        vehicleParser = new VehicleCreator(parseVehicleData(reader));
        vehicles.put("Bus", vehicleParser.createVehicleFromData());


        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {

            String[] tokens = parseVehicleData(reader);
            CommandExecutor commandExecutor = new CommandExecutor(tokens, vehicles);
            commandExecutor.executeCommand();
        }

        vehicles
                .values().
                forEach(System.out::println);
    }

    private static String[] parseVehicleData(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split("\\s+"))
                .toArray(String[]::new);
    }
}
