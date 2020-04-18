import java.util.Scanner;

public class GraduationPart2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String studentName = sc.nextLine();

        int classCount = 1;
        double marksSum = 0.0;
        int yearRepeate = 0;

        boolean isExcluded = false;

        while (classCount <= 12) {
            double studentYearMark = Double.parseDouble(sc.nextLine());

            if (studentYearMark >= 4) {
                marksSum += studentYearMark;
                classCount++;

            } else {
                yearRepeate++;

            }

            if (yearRepeate > 1) {
                isExcluded = true;
                break;
            }
        }

        double avarageMark = marksSum / 12;

        if (isExcluded) {
            System.out.printf("%s has been excluded at %d grade", studentName, classCount);

        } else {

            System.out.printf("%s graduated. Average grade: %.2f", studentName, avarageMark);
        }

    }
}
