package border_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class Main {
    private static final String END = "End";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        List<Identifiable> society = new ArrayList<>();

        while (!END.equals(input)) {
            String[] tokens = input.split("\\s+");
            if (isCitizen(tokens.length)) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                Identifiable citizen = new Citizen(name, age, id);
                society.add(citizen);

            } else {
                String model = tokens[0];
                String id = tokens[1];
                Identifiable robot = new Robot(model, id);
                society.add(robot);
            }

            input = reader.readLine();
        }

        String lastNumberOfId = reader.readLine();

        Predicate<Identifiable> isDetained = inhabited -> inhabited.getId().endsWith(lastNumberOfId);
        society
                .stream()
                .filter(isDetained)
                .forEach(inhabited -> System.out.println(inhabited.getId()));
    }

    private static boolean isCitizen(int length) {
        return length == 3;
    }
}
