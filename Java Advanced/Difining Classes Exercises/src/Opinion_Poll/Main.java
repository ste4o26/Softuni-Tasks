package Opinion_Poll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Predicate;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Person> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String personDate = reader.readLine();
            String[] tokens = personDate.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);

            people.putIfAbsent(name, person);
        }

        BiConsumer<String, Person> printPersonData = (k, v) -> System.out.printf("%s - %d%n", k, v.getAge());
        Predicate<Person> isOver30 = person -> person.getAge() > 30;

        people.entrySet()
                .stream()
                .filter(entry -> isOver30.test(entry.getValue()))
                .sorted((person1, person2) -> person1.getKey().compareTo(person2.getKey()))
                .forEach(entry -> printPersonData.accept(entry.getKey(), entry.getValue()));
    }
}
