package Car_Info2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Car> cars = new ArrayList<>();
        fillCarsList(cars, reader);
        cars.forEach(Car::carInfo);
    }

    static void fillCarsList(List<Car> cars, BufferedReader reader) {
        try (reader) {
            int numberOfCars = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numberOfCars; i++) {

                String[] tokens = reader.readLine().split("\\s+");
                String carMake = tokens[0];

                if (tokens.length <= 1) {
                    Car car = new Car(carMake);
                    cars.add(car);
                } else {
                    String carModel = tokens[1];
                    int carHorsePowers = Integer.parseInt(tokens[2]);
                    Car car = new Car(carMake, carModel, carHorsePowers);
                    cars.add(car);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
