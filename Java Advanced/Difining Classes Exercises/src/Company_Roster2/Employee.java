package Company_Roster2;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String email;
    private int age;

    public Employee(String name, double salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.email = "n/a";
        this.age = -1;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d",
                this.name,
                this.salary,
                this.email,
                this.age);
    }
}
