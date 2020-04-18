package Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> people = new LinkedHashMap<>();

        String inputLine = reader.readLine();
        while (!"End".equals(inputLine)) {
            String[] tokens = inputLine.split("\\s+");
            String personName = tokens[0];
            Person person = people.get(personName);
            if (person == null){
                person = new Person(personName);
            }

            String command = tokens[1];
            switch (command) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    Company company = new Company(companyName, department, salary);
                    person.setCompany(company);
                    break;

                case "pokemon":
                    String pokemonName = tokens[2];
                    String element = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, element);
                    person.addPokemon(pokemon);
                    break;

                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    person.addParent(parent);
                    break;

                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Child child = new Child(childName, childBirthday);
                    person.addChild(child);
                    break;

                case "car":
                    String model = tokens[2];
                    int speed = Integer.parseInt(tokens[3]);
                    Car car = new Car(model, speed);
                    person.setCar(car);
                    break;
            }

            people.putIfAbsent(personName, person);
            inputLine = reader.readLine();
        }

        inputLine = reader.readLine();
        Person person = people.get(inputLine);
        System.out.println(person);
        person.printData("Company", person.getCompany());
        person.printData("Car", person.getCar());
        person.printData("Pokemon", person.getPokemons());
        person.printData("Parents", person.getParents());
        person.printData("Children", person.getChildren());


    }
}
