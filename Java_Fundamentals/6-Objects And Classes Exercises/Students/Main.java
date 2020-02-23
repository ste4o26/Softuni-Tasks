package Students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(sc.nextLine());
        List<Student> listOfStudents = new ArrayList<Student>();
        fillList(listOfStudents, numberOfStudents, sc);

        listOfStudents.stream()
                .sorted((student1, student2) -> Double.compare(student2.getGrade(), student1.getGrade()))
                .forEach(element -> System.out.println(element));
    }

    static void fillList(List<Student> listOfStudents, int numberOfStudents, Scanner sc){
        for (int i = 0; i < numberOfStudents; i++) {
            String[] input = sc.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            double grade = Double.parseDouble(input[2]);
            Student student = new Student(firstName, lastName, grade);
            listOfStudents.add(student);
        }
    }
}
