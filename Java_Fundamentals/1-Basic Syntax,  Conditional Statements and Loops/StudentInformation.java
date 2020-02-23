import java.util.Scanner;
public class StudentInformation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String studentName = sc.nextLine();
        int studentAge = Integer.parseInt(sc.nextLine());
        double studentGrade = Double.parseDouble(sc.nextLine());

        System.out.printf("Name: %s, Age: %d, Grade: %.2f", studentName, studentAge, studentGrade);
    }
}
