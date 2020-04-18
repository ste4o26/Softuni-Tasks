package GenericScale;

public class Main {

    public static void main(String[] args) {

        Scale<String> stringScale = new Scale<>("Alice", "Bob");
        System.out.println(stringScale.getHeavier());

        Scale<Double> doubleScale = new Scale<>(5.8, 3.16);
        System.out.println(doubleScale.getHeavier());
    }
}
