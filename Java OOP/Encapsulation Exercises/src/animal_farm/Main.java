package animal_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Chicken chicken = null;
        try {
            chicken = createChickenFromInput(reader);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        if (chicken != null) {
            System.out.println(chicken);
        }

    }

    private static Chicken createChickenFromInput(BufferedReader reader) throws IOException {
        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        return new Chicken(name, age);
    }
}
