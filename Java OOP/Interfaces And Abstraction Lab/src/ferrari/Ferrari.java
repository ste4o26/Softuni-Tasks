package ferrari;
public class Ferrari implements Car {
    private String driverName;
    private String model;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.model = "488-Spider";
    }

    public String getDriverName() {
        return this.driverName;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String brakes() {
        return "Brakes";
    }

    @Override
    public String gas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",
                this.getModel(),
                this.brakes(),
                this.gas(),
                this.getDriverName());
    }
}
