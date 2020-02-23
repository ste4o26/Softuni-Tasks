package VehicleCatalogue;

import java.util.List;

public class Vehicle {
    private String typeOfVehicle;
    private String model;
    private String color;
    private int horsePower;

    public Vehicle(String typeOfVehicle, String model, String color, int horsePower){
        this.typeOfVehicle = typeOfVehicle;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getTypeOfVehicle(){
        return this.typeOfVehicle;
    }

    public String getModel(){
        return this.model;
    }

    public String getColor(){
        return this.color;
    }

    public int getHorsePower(){
        return this.horsePower;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%n" +
                "Model: %s%n" +
                "Color: %s%n" +
                "Horsepower: %d", this.typeOfVehicle.substring(0, 1).toUpperCase() + this.typeOfVehicle.substring(1), this.model, this.color, this.horsePower);
                    //substring metoda vzema nachalo i kraj na string ili samo nachalo i  raboti v tezi ramki
    }
}
