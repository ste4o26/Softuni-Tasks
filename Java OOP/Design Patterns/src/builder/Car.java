package builder;

public class Car {
    private final String brand;
    private final String model;
    private final String color;
    private final int numberOfDoors;
    private final String registeredCity;
    private final String fuelType;

    public Car(String brand, String model, String color, int numberOfDoors, String registeredCity, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.numberOfDoors = numberOfDoors;
        this.registeredCity = registeredCity;
        this.fuelType = fuelType;
    }

    public static CarBuilder newBuilder(){
        return new CarBuilder();
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public String getColor() {
        return this.color;
    }

    public int getNumberOfDoors() {
        return this.numberOfDoors;
    }

    public String getRegisteredCity() {
        return this.registeredCity;
    }

    public String getFuelType() {
        return this.fuelType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                ", registeredCity='" + registeredCity + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
