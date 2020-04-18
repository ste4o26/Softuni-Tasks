package RawData;

import java.util.Map;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires tires;

    public Car(String model, Engine engine, Cargo cargo, Tires tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Tires getTires() {
        return this.tires;
    }

    public boolean isFragile() {
        if ("fragile".equals(this.cargo.getType())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isTirePressureLessThan1() {
        Tires tires = this.getTires();
        Map<Double, Integer> tirePressureAge = tires.getTirePressureAge();

        for (double pressure : tirePressureAge.keySet()) {
            if (pressure < 1){
                return true;
            }
        }
        return false;
    }

    public boolean isEnginePowerMoreThan250() {
        if (this.engine.getPower() > 250) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%s", this.model);
    }
}
