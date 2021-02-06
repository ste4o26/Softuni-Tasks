package entities;

public class Student {
    private int id;
    private String name;
    private int age;
    private int facultyNumber;

    public Student() {
    }

    public Student(String name, int age, int facultyNumber) {
        this.setName(name);
        this.setAge(age);
        this.setFacultyNumber(facultyNumber);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(int facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}
