package Car_Info;

public class Car {
    private String make;
    private String model;
    private int horsePowers;

    public Car(String make, String model, int horsePowers) {
        this.make = make;
        this.model = model;
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


    public void carInfo(){
        String infoOutput = String.format("The car is: %s %s - %d HP.", this.getMake(), this.getModel(), this.getHorsePowers());
        System.out.println(infoOutput);
    }
}
