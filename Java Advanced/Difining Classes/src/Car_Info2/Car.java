package Car_Info2;

public class Car {
    private static final String UNKNOWN_MODEL = "unknown";
    private static final int UNKNOWN_HORSE_POWERS = -1;

    private String make;
    private String model;
    private int horsePowers;

    public Car(String make, String model, int horsePowers) {
        this.make = make;
        this.model = model;
        this.horsePowers = horsePowers;
    }

    public Car(String make) {
        this.make = make;
        this.setModel(UNKNOWN_MODEL);
        this.setHorsePowers(UNKNOWN_HORSE_POWERS);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePowers(int horsePowers) {
        this.horsePowers = horsePowers;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePowers() {
        return horsePowers;
    }

    public void carInfo() {
        String carInfoOutput = String.format("The car is: %s %s - %d HP.",
                this.getMake(),
                this.getModel(),
                this.getHorsePowers());
        System.out.println(carInfoOutput);
    }
}
