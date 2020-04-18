package animals;

public class Animal {
    private static final String MALE = "Male";
    private static final String FEMALE = "Female";

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.length() < 1) {
            throwIllegalArgumentException();
        } else {
            this.name = name;
        }
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 1) {
            throwIllegalArgumentException();
        }
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        if (MALE.equals(gender) || FEMALE.equals(gender)) {
            this.gender = gender;
        } else {
            throwIllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s",
                this.getClass().getSimpleName(),
                this.getName(),
                this.getAge(),
                this.getGender(),
                this.produceSound());
    }

    public void throwIllegalArgumentException() {
        throw new IllegalArgumentException("Invalid input!");
    }

    public String produceSound() {
        return this.produceSound();
    }
}
