package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String inputLine = reader.readLine();
            String[] tokens = inputLine.split("\\s+");
            String model = tokens[0];

            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Tires tires = new Tires();
            for (int k = 5; k < tokens.length; k += 2) {
                double tirePressure = Double.parseDouble(tokens[k]);
                int tireAge = Integer.parseInt(tokens[k + 1]);
                tires.setTirePressureAge(tirePressure, tireAge);
            }

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = reader.readLine();
        if ("fragile".equals(command)) {

            cars
                    .stream()
                    .filter(Car::isFragile)
                    .filter(Car::isTirePressureLessThan1)
                    .forEach(System.out::println);

        } else {
            cars
                    .stream()
                    .filter(car -> !car.isFragile())
                    .filter(car -> car.isEnginePowerMoreThan250())
                    .forEach(car -> System.out.println(car));
        }
    }
}
