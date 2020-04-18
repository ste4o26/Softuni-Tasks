package Car_Info;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fillCarsList(cars, reader);
        printCarsInfo(cars);
    }

    static void printCarsInfo(List<Car> cars){
        cars.forEach(car -> car.carInfo());
    }


    static void fillCarsList(List<Car> cars, BufferedReader reader){
        try(reader){
            int numberOfCars = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numberOfCars; i++) {
                String[] tokens = reader.readLine().split("\\s+");
                String carMake = tokens[0];
                String carModel = tokens[1];
                int carHorsePowers = Integer.parseInt(tokens[2]);
                Car car = new Car(carMake, carModel, carHorsePowers);
                cars.add(car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
