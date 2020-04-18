package animal_farm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }

    private int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age > 0 && age < 15) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        //First 6 years it produces 2 eggs per day [0 - 5]
        //
        //Next 6 years it produces 1 egg per day [6 - 11]
        //
        //And after that it produces 0.75 eggs per day

        if (this.getAge() >= 12) {
            return 0.75;
        } else if (this.getAge() >= 6) {
            return 1.0;
        } else {
            return 2.0;
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken Mara (age %d) can produce %.2f eggs per day.",
                this.getAge(),
                this.productPerDay());
    }
}