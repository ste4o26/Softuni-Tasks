package OpinionPoll;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int linesOfPersonalInformation = Integer.parseInt(sc.nextLine());
        List<Person> listOfPeople = new ArrayList<Person>();
        for (int i = 0; i < linesOfPersonalInformation; i++) {
            String[] personalInformation = sc.nextLine().split("\\s+");
            String name = personalInformation[0];
            int age = Integer.parseInt(personalInformation[1]);

            Person person = new Person(name, age);
            listOfPeople.add(person);
        }

        /*Sorting list with lambda expressions!!!*/
        listOfPeople = listOfPeople.stream().sorted((person1, person2) -> person1.getName().compareTo(person2.getName())).collect(Collectors.toList());
        //vmesto da go prisvoqvam moga da mu napisha .foreach pak s nqkvi lamda funkcii :D
        for (int i = 0; i < listOfPeople.size(); i++) {
            if(listOfPeople.get(i).isOlderThan30(listOfPeople.get(i).getAge())){
                System.out.println(listOfPeople.get(i));
            }
        }
    }
}
