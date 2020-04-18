package Strategy_Pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> peopleByName = new TreeSet<>(new PersonComparatorByName());
        Set<Person> peopleByAge = new TreeSet<>(new PersonComparatorByAge());
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            peopleByName.add(person);
            peopleByAge.add(person);
        }

        System.out.println();
        peopleByName.forEach(System.out::println);
        peopleByAge.forEach(System.out::println);
    }
}
