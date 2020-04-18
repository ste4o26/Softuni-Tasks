import java.util.Scanner;

public class OnTimeForTheExam {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int examHours = Integer.parseInt(sc.nextLine());
        int examMins = Integer.parseInt(sc.nextLine());

        int arrivelHours = Integer.parseInt(sc.nextLine());
        int arrivelMins = Integer.parseInt(sc.nextLine());

        int totalExamMinutes = (examHours * 60) + examMins;
        int totalArrivalMinutes = (arrivelHours * 60) + arrivelMins;

        int diff = totalExamMinutes - totalArrivalMinutes; // ako e otricatelno chislo e zakusnql, ako e po malko ot 30 e na vreme i ako e po golqmo ot 30 e podranil

        boolean isEarly = diff < 30;
        boolean isOnTime = diff <= 30;
        boolean isLate = diff < 0;


        if (isLate) {
            System.out.println("Late");

        } else if (isOnTime) {
            System.out.println("On time");

        } else {
            System.out.println("Early");

        }


        if (isLate) {
            if (diff > -60) {
                System.out.printf("%d minutes after the start", Math.abs(diff));

            } else {
                int hour = Math.abs(diff) / 60;
                int minutes = Math.abs(diff) % 60;

                if (minutes < 10) {
                    System.out.printf("%d:0%d hours after the start", hour, minutes);
                } else {
                    System.out.printf("%d:%d hours after the start", hour, minutes);
                }
            }

        } else if (isOnTime && diff > 0) {
            System.out.printf("%d minutes before the start", diff);

        } else {
            int hours = diff / 60;
            int minutes = diff % 60;

            if (diff < 60) {
                System.out.printf("%d minutes before the start", minutes);

            } else {
                if (minutes < 10) {
                    System.out.printf("%d:0%d hours before the start", hours, minutes);
                }else {
                    System.out.printf("%d:%d hours before the start", hours, minutes);
                }
            }
        }


    }
}
