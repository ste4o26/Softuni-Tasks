import java.util.Scanner;

public class ExamPreparation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int badDegrees = Integer.parseInt(sc.nextLine());

        int badDegreesCounter = 0;
        boolean isEnough = false;
        int tasksCounter = 0;
        double sum = 0.0;
        String lastTask = null;
        String taskName = null;

        while (badDegreesCounter < badDegrees) {
            taskName = sc.nextLine();

            if (taskName.equals("Enough")) {
                isEnough = true;
                break;
            }

            lastTask = taskName;

            int taskGrade = Integer.parseInt(sc.nextLine());


            if (taskGrade <= 4) {
                badDegreesCounter++;

            }

            sum += taskGrade;
            tasksCounter++;
        }

        double avarageGrade = sum / tasksCounter;

        if(isEnough){
            System.out.printf("Average score: %.2f\n", avarageGrade);
            System.out.printf("Number of problems: %d\n", tasksCounter);
            System.out.printf("Last problem: %s\n", lastTask);

        }else {
            System.out.printf("You need a break, %d poor grades.\n", badDegrees);

        }


    }
}
