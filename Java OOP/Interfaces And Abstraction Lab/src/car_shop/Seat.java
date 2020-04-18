package car_shop;

public class Seat extends CarImpl implements Sellable {

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "%n" + "Leon sells for %f",
                this.getPrice());
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
