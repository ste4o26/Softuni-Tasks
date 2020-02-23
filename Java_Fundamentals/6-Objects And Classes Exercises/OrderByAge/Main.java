package OrderByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Person> listOfPeople = new ArrayList<Person>();
        fillList(listOfPeople, sc);
        listOfPeople.stream()
                .sorted((person1, person2) -> Integer.compare(person1.getAge(), person2.getAge()))
                .forEach(element -> System.out.println(element));
    }

    static void fillList(List<Person> listOfPeople, Scanner sc){
        String input = sc.nextLine();
        while (!input.equalsIgnoreCase("end")){
            String[] peopleData = input.split(" ");
            String name = peopleData[0];
            String ID = peopleData[1];
            int age = Integer.parseInt(peopleData[2]);
            Person person = new Person(name, ID, age);
            listOfPeople.add(person);
            input = sc.nextLine();
        }
    }


}
