package valid_person;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private PersonValidator validator;

    public Person(String firstName, String lastName, int age) {
        this.validator = new PersonValidator();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public String getFirstName() {
        return this.firstName;
    }

    protected void setFirstName(String firstName) {
        try {
            validator.isValidName(firstName);
        } catch (IllegalArgumentException iae) {
            throw new InvalidPersonNameException("The first " + iae.getMessage(), iae);
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    protected void setLastName(String lastName) {
        try {
            validator.isValidName(lastName);
        } catch (IllegalArgumentException iae) {
            throw new InvalidPersonNameException("The last " + iae.getMessage(), iae);
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    protected void setAge(int age) {
        validator.isValidAge(age);
        this.age = age;
    }
}
