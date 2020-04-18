package Strategy_Pattern;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {

        String firstPersonName = firstPerson.getName().toUpperCase();
        String secondPersonName = secondPerson.getName().toUpperCase();
        int result = firstPersonName.length() - secondPersonName.length();

        return (result == 0 ? firstPersonName.charAt(0) - secondPersonName.charAt(0) : result);
    }
}
