package box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Box box = null;
        try {
            box = createBoxFromInput(reader);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        System.out.println(box);

    }

    private static Box createBoxFromInput(BufferedReader reader) throws IOException {
        double length = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());
        return new Box(length, width, height);
    }
}
