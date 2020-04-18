import java.util.Scanner;

public class Grades {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(sc.nextLine());

        double topStudents = 0;
        double greatStudents = 0;
        double goodStudents = 0;
        double faliures = 0;
        double totalGradesSum = 0;

        for (int student = 1; student <= numberOfStudents; student++) {
            double studentGrade = Double.parseDouble(sc.nextLine());

            if(studentGrade >= 5.00){
                topStudents++;
            }else if(studentGrade >= 4.00){
                greatStudents++;
            }else if(studentGrade >= 3.00){
                goodStudents++;
            }else if(studentGrade >= 2.00){
                faliures++;
            }
            totalGradesSum += studentGrade;
        }

        double allStudents = topStudents + greatStudents + goodStudents + faliures;
        double gradesAbouveFive = (topStudents / allStudents) * 100;
        double gradesAbouveFour = (greatStudents / allStudents) * 100;
        double gradesAbouveThree = (goodStudents / allStudents) * 100;
        double faliuareGrades = (faliures / allStudents) * 100;
        double averageGrade = totalGradesSum / allStudents;

        System.out.printf("Top students: %.2f%c%n", gradesAbouveFive, '%');
        System.out.printf("Between 4.00 and 4.99: %.2f%c%n", gradesAbouveFour, '%');
        System.out.printf("Between 3.00 and 3.99: %.2f%c%n", gradesAbouveThree, '%');
        System.out.printf("Fail: %.2f%c%n", faliuareGrades, '%');
        System.out.printf("Average: %.2f", averageGrade);
    }
}
