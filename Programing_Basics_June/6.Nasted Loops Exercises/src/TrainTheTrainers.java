import java.util.Scanner;

public class TrainTheTrainers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfJudges = Integer.parseInt(sc.nextLine());
        double totalGradesSum = 0.0;
        double totalAverageSum = 0.0;
        int numberOfPresentations = 0;
        String presentationName = sc.nextLine();

        while (!(presentationName.equals("Finish"))) {
            double averagePresentationGrade = 0.0;

            for (int presentationGrade = 1; presentationGrade <= numberOfJudges; presentationGrade++) {
                double grade = Double.parseDouble(sc.nextLine());
                averagePresentationGrade += grade;
                totalGradesSum += grade;
                numberOfPresentations++;
            }
            averagePresentationGrade /= numberOfJudges;
            System.out.printf("%s - %.2f.%n", presentationName, averagePresentationGrade);

            presentationName = sc.nextLine();
        }
        totalAverageSum = totalGradesSum / numberOfPresentations;
        System.out.printf("Student's final assessment is %.2f.", totalAverageSum);
    }
}