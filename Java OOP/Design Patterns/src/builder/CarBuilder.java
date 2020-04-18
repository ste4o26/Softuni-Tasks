package builder;

public class CarBuilder implements Builder {
    private String brand;
    private String model;
    private String color;
    private int numberOfDoors;
    private String registeredCity;
    private String fuelType;

    public CarBuilder() {
        this.brand = "n/a";
        this.model = "n/a";
        this.color = "n/a";
        this.numberOfDoors = 0;
        this.registeredCity = "n/a";
        this.fuelType = "n/a";
    }

    public CarBuilder withBrand(String brand) {
        this.brand = brand;
        return this;
    }


    public CarBuilder withModel(String model) {
        this.model = model;
        return this;
    }


    public CarBuilder withColor(String color) {
        this.color = color;
        return this;
    }


    public CarBuilder withNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
        return this;
    }


    public CarBuilder withRegisteredCity(String registeredCity) {
        this.registeredCity = registeredCity;
        return this;
    }


    public CarBuilder withFuelType(String fuelType) {
        this.fuelType = fuelType;
        return this;
    }


    @Override
    public Car build() {
        return new Car(this.brand, this.model, this.color, this.numberOfDoors, this.registeredCity, this.fuelType);
    }
}
