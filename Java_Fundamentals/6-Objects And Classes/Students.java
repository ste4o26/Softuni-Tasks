import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Students {

    static class Student {
        private String firstName;
        private String lastName;
        private String age;
        private String homeTown;

        public Student(String firstName, String lastName, String age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getAge() {
            return this.age;
        }

        public String getHomeTown() {
            return this.homeTown;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Student> studentsList = new ArrayList<Student>();
        fillStudentList(studentsList, sc);
        String cityFilter = sc.nextLine();
        printStudentsFromCity(studentsList, cityFilter);
    }

    static void fillStudentList(List<Student> studentsList, Scanner sc) {
        String input = sc.nextLine();
        while (!input.equalsIgnoreCase("end")) {
            String[] studentData = input.split("\\s+");
            Student student = new Student(studentData[0], studentData[1], studentData[2], studentData[3]);
            studentsList.add(student);

            input = sc.nextLine();
        }
    }


    static void printStudentsFromCity(List<Student> listOfStudents, String cityFilter){
        for (Student currentStudent : listOfStudents) {
            if(currentStudent.getHomeTown().equalsIgnoreCase(cityFilter)){
                System.out.printf("%s %s is %s years old%n", currentStudent.getFirstName(), currentStudent.getLastName(), currentStudent.getAge());
            }
        }
    }
}
