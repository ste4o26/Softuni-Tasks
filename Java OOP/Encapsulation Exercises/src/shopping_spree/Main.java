package shopping_spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    private static final String END = "END";

    //SOO POORLY ORGANISED MAIN NEED REFACTOR !!!

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        try {
            people = fillListWithPeople(reader);
            products = fillListWithProducts(reader);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }

        String input = reader.readLine();
        while (!END.equals(input)) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];

            Product product = null;
            for (Product currentProduct : products) {
                if (currentProduct.getName().equals(productName)) {
                    product = currentProduct;
                    break;
                }
            }

            for (Person person : people) {
                if (person.getName().equals(personName)) {
                    try {
                        person.buyProduct(product);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                }
            }

            input = reader.readLine();
        }

        people.forEach(System.out::println);
    }


    // DA Q PRERESHA KOGATO NAUCHA ZA REFLECTION!!!

    private static List<Product> fillListWithProducts(BufferedReader reader) throws IOException {
        String[] tokens = reader.readLine().split(";");
        ArrayList<Product> products = new ArrayList<>();

        Function<String, Product> createPersonByGivenToken = (token -> {
            String[] personData = token.split("=");
            String name = personData[0];
            double money = Double.parseDouble(personData[1]);
            return new Product(name, money);
        });

        Arrays
                .stream(tokens)
                .map(createPersonByGivenToken)
                .forEach(products::add);

        return products;
    }


    private static List<Person> fillListWithPeople(BufferedReader reader) throws IOException {
        String[] tokens = reader.readLine().split(";");
        ArrayList<Person> people = new ArrayList<>();

        Function<String, Person> createPersonByGivenToken = (token -> {
            String[] personData = token.split("=");
            String name = personData[0];
            double money = Double.parseDouble(personData[1]);
            return new Person(name, money);
        });

        Arrays
                .stream(tokens)
                .map(createPersonByGivenToken)
                .forEach(people::add);

        return people;
    }
}
