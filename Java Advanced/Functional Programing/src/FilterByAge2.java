import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FilterByAge2 {

    public static void main(String[] args) {
        Map<String, Integer> people = new LinkedHashMap<>();

        BiPredicate<Map.Entry<String, Integer>, Integer> isYoungerThan = (person, ageLimit) -> person.getValue() < ageLimit;
        BiPredicate<Map.Entry<String, Integer>, Integer> isOlderThan = (person, ageLimit) -> person.getValue() >= ageLimit;

        Consumer<Map.Entry<String, Integer>> printName = person -> System.out.println(person.getKey());
        Consumer<Map.Entry<String, Integer>> printAge = person -> System.out.println(person.getValue());
        Consumer<Map.Entry<String, Integer>> printNameAndAge = person -> System.out.printf("%s - %s%n", person.getKey(), person.getValue());

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));) {
            fillMap(people, bf);
            String condition = bf.readLine();
            int ageLimit = Integer.parseInt(bf.readLine());
            String format = bf.readLine();

            people
                    .entrySet()
                    .stream()
                    //vmesto ternaren operator e po dobre da polzvam if else poneje sus ternarniq operator proverqva dali conditiona e younger ili older za vseki element ot streama a ne vednuj kakto shte e pri if else
                    .filter(person -> condition.equals("younger") ?
                            isYoungerThan.test(person, ageLimit) :
                            isOlderThan.test(person, ageLimit))
                  //  .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()))    ->  vrashta hashMap !!!!!
                    .forEach(person -> {
                        switch (format) {
                            case "name":
                                printName.accept(person);
                                break;

                            case "age":
                                printAge.accept(person);
                                break;

                            case "name age":
                                printNameAndAge.accept(person);
                                break;
                        }
                    });


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void fillMap(Map<String, Integer> map, BufferedReader bf) {
        try {
            int peopleCount = Integer.parseInt(bf.readLine());
            for (int i = 0; i < peopleCount; i++) {
                String[] tokens = bf.readLine().split(", ");
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                map.put(name, age);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
