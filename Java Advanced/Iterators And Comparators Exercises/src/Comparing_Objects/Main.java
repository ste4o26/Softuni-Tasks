package Comparing_Objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        List<Person> people = new ArrayList<>();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];
            Person person = new Person(name, age, town);

            people.add(person);

            input = reader.readLine();
        }

        int index = Integer.parseInt(reader.readLine());
        boolean isInBounds = index >= 0 && index < people.size();
        if (!isInBounds) {
            System.out.println("No matches");
            return;
        }

        int equalPeopleCount = 0;
        int notEqualPeopleCount = 0;
        Person personToCompareWith = people.get(index);
        for (Person person : people) {
            if (person.compareTo(personToCompareWith) == 0){
                equalPeopleCount++;
            }else {
                notEqualPeopleCount++;
            }
        }

        System.out.printf("%d %d %d%n", equalPeopleCount, notEqualPeopleCount, people.size());
    }
}
