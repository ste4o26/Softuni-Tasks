package Strategy_Pattern;

import java.util.Comparator;

public class PersonComparatorByAge implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return firstPerson.getAge() - secondPerson.getAge();
    }
}
