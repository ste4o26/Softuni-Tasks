import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterByAge {

    public static void main(String[] args) {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> personAge = new LinkedHashMap<>();

        fillMap(personAge, bf);
        try {
            String condition = bf.readLine();
            int age = Integer.parseInt(bf.readLine());
            String format = bf.readLine();

            // Predicate<Integer> peopleYoungerThan = e -> e <= age;

            Map<String, Integer> result = new LinkedHashMap<>();
            if (condition.equals("younger")) {
                result = personAge
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() <= age)
                        .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));

            } else {
                result = personAge
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() >= age)
                        .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));

            }

            switch (format) {
                case "name":
                    result
                            .keySet()
                            .forEach(e -> System.out.println(e));
                    break;

                case "age":
                    result
                            .values()
                            .forEach(e -> System.out.println(e));
                    break;

                case "name age":
                    result
                            .entrySet()
                            .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void fillMap(Map<String, Integer> map, BufferedReader bf) {
        try {
            int numberOfInputLines = Integer.parseInt(bf.readLine());
            for (int i = 0; i < numberOfInputLines; i++) {
                String[] tokens = bf.readLine().split(",\\s+");
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                map.put(name, age);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
