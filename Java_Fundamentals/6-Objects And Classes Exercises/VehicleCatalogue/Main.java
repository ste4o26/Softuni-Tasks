package VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Vehicle> listOfCars = new ArrayList<Vehicle>();
        List<Vehicle> listOfTrucks = new ArrayList<Vehicle>();
        List<Vehicle> listOfVehicles = new ArrayList<Vehicle>();

        fillList(listOfVehicles, listOfCars, listOfTrucks, sc);
        printFilteredVehicles(listOfVehicles, sc);
        printCarsAverageHorsePower(listOfCars);
        printTrucksAverageHorsePower(listOfTrucks);


    }

    static void fillList(List<Vehicle> listOfVehicles, List<Vehicle> listOfCars, List<Vehicle> listOfTrucks, Scanner sc) {
        String input = sc.nextLine();

        while (!input.equalsIgnoreCase("End")) {
            String[] vehicleData = input.split(" ");
            String typeOfVehicle = vehicleData[0];
            String model = vehicleData[1];
            String color = vehicleData[2];
            int horsePower = Integer.parseInt(vehicleData[3]);
            Vehicle vehicle = new Vehicle(typeOfVehicle, model, color, horsePower);
            if (vehicle.getTypeOfVehicle().equalsIgnoreCase("car")) {
                listOfCars.add(vehicle);
            } else {
                listOfTrucks.add(vehicle);
            }

            listOfVehicles.add(vehicle);
            input = sc.nextLine();
        }
    }


    static void printCarsAverageHorsePower(List<Vehicle> listOfCars) {
        double sumOfHorsePowers = 0;
        //granichen sluchai !!! mnogo sa vajni da se zamislqm za takiva !!!
        if (listOfCars.size() == 0) {
            System.out.printf("Cars have average horsepower of: %.2f.%n", 0.0);
        } else {
            for (Vehicle currentVehicle : listOfCars) {
                sumOfHorsePowers += currentVehicle.getHorsePower();
            }

            double carsAverageHorsePower = sumOfHorsePowers / listOfCars.size();
            System.out.printf("Cars have average horsepower of: %.2f.%n", carsAverageHorsePower);
        }
    }

    static void printTrucksAverageHorsePower(List<Vehicle> listOfTrucks) {
        double sumOfHorsePowers = 0;
        //granichen sluchai !!! mnogo sa vajni da se zamislqm za takiva !!!
        if (listOfTrucks.size() == 0) {
            System.out.printf("Trucks have average horsepower of: %.2f.%n", 0.0);
        } else {
            for (Vehicle currentVehicle : listOfTrucks) {
                sumOfHorsePowers += currentVehicle.getHorsePower();
            }

            double trucksAverageHorsePower = sumOfHorsePowers / listOfTrucks.size();
            System.out.printf("Trucks have average horsepower of: %.2f.%n", trucksAverageHorsePower);
        }
    }

    static void printFilteredVehicles(List<Vehicle> listOfVehicles, Scanner sc) {
        String input = sc.nextLine();
        while (!input.equalsIgnoreCase("Close the Catalogue")) {
            String model = input;
            for (Vehicle currentVehicle : listOfVehicles) {
                if (model.equalsIgnoreCase(currentVehicle.getModel())) {
                    System.out.println(currentVehicle);
                    break;
                }
            }
            input = sc.nextLine();
        }
    }
}
