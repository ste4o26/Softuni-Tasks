package CarSalesman2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Engine> engines = new ArrayList<>();
        int enginesCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < enginesCount; i++) {
            String inputLine = reader.readLine();
            String[] tokens = inputLine.split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            Engine engine = new Engine(model, power);

            if (tokens.length == 3) {
                if (Character.isDigit(tokens[2].charAt(0))) {
                    String displacement = tokens[2];
                    engine.setDisplacement(displacement);
                } else {
                    String efficiency = tokens[2];
                    engine.setEfficiency(efficiency);
                }

            } else if (tokens.length == 4) {
                String displacement = tokens[2];
                String efficiency = tokens[3];
                engine.setDisplacement(displacement);
                engine.setEfficiency(efficiency);
            }
            engines.add(engine);
        }

        List<Car> cars = new ArrayList<>();
        int carsCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < carsCount; i++) {
            String inputLine = reader.readLine();
            String[] tokens = inputLine.split("\\s+");
            String model = tokens[0];
            String engineModel = tokens[1];
            Engine engine = getEngine(engines, engineModel);
            Car car = new Car(model, engine);

            if (tokens.length == 3) {
                if (Character.isDigit(tokens[2].charAt(0))) {
                    String weight = tokens[2];
                    car.setWeight(weight);
                } else {
                    String color = tokens[2];
                    car.setColor(color);
                }

            } else if (tokens.length == 4) {
                String weight = tokens[2];
                String color = tokens[3];
                car.setWeight(weight);
                car.setColor(color);
            }

            cars.add(car);
        }

        cars.forEach(car -> {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngine().getModel() + ":");
            System.out.println("Power: " + car.getEngine().getPower());
            System.out.println("Displacement: " + car.getEngine().getDisplacement());
            System.out.println("Efficiency: " + car.getEngine().getEfficiency());
            System.out.println("Weight: " + car.getWeight());
            System.out.println("Color: " + car.getColor());
        });
    }

    private static Engine getEngine(List<Engine> engines, String model) {
        for (int i = 0; i < engines.size(); i++) {
            Engine currentEngine = engines.get(i);
            if (currentEngine.getModel().equals(model)) {
                return currentEngine;
            }
        }
        return null;//not good idea to return null and not handle it like now
    }
}
