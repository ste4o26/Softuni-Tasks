package builder;

public class Main {
    public static void main(String[] args) {
        Car ford = Car.newBuilder()
                .withBrand("Ford")
                .withModel("Focus")
                .withFuelType("Diesel")
                .build();

        System.out.println(ford);


        Car ww = Car.newBuilder()
                .withBrand("WW")
                .withModel("Golf")
                .withFuelType("1.9 TDI")
                .withColor("Black")
                .withNumberOfDoors(4)
                .withRegisteredCity("Sofia")
                .build();

        System.out.println(ww);
    }
}
