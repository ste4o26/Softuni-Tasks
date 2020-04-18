import java.util.Scanner;

public class Graduation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String studentName = sc.nextLine();

        int studentClass = 1;
        double sumOfStudentGrades = 0.0;

        while(studentClass <= 12){
            double studentGrade = Double.parseDouble(sc.nextLine());


            if(studentGrade >= 4) {
                sumOfStudentGrades += studentGrade;
                studentClass++;
            }
        }

        double avarageGrade = sumOfStudentGrades / 12;
        System.out.printf("%s graduated. Average grade: %.2f", studentName, avarageGrade);

    }
}
