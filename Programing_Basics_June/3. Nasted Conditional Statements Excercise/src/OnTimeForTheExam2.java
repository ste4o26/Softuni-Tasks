    import java.util.Scanner;

    public class OnTimeForTheExam2 {
//WRONG VERSION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//WRONG VERSION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//WRONG VERSION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//WRONG VERSION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int examHours = Integer.parseInt(sc.nextLine());
            int examMinutes = Integer.parseInt(sc.nextLine());

            int arrivalHours = Integer.parseInt(sc.nextLine());
            int arrivalMinutes = Integer.parseInt(sc.nextLine());

            int totalExamMinutes = (examHours * 60) + examMinutes;
            int totalArrivalMinutes = (arrivalHours * 60) + arrivalMinutes;

            int diff = Math.abs(totalExamMinutes - totalArrivalMinutes);

            boolean isEarly = totalArrivalMinutes <= totalExamMinutes;
            boolean isLate = totalArrivalMinutes >= totalExamMinutes;
            boolean isOnTime = isEarly && diff <= 30;
            boolean isArrivalEarlierThenHour = isEarly && diff <= 59;
            boolean isArrivalEarlierMoreThenHour = isEarly && diff >= 60;
            boolean isArrivalLaterThenHour = isLate && diff <= 59;
            boolean isArrivalLaterMoreThenHour = isLate && diff >= 60;


            int earlyLateArrivalHours = diff / 60;
            int earlyLateArrivalMinutes = diff % 60;

            if (isOnTime) {
                System.out.println("On time");
                System.out.printf("%d minutes before the start", earlyLateArrivalMinutes);

            } else if (isArrivalEarlierThenHour) {
                System.out.println("Early");
                System.out.printf("%d minutes before the start", earlyLateArrivalMinutes);

            } else if (isArrivalEarlierMoreThenHour) {

                if (diff < 10 || diff == 60) {
                    System.out.println("Early");
                    System.out.printf("%d:0%d hours before the start", earlyLateArrivalHours, earlyLateArrivalMinutes);

                } else {
                        System.out.println("Early");
                        System.out.printf("%d:%d hours before the start", earlyLateArrivalHours, earlyLateArrivalMinutes);
                    }

            } else if (isArrivalLaterThenHour) {
                System.out.println("Late");
                System.out.printf("%d minutes after the start", earlyLateArrivalMinutes);

            } else if (isArrivalLaterMoreThenHour) {
                if (diff < 10 || diff == 60) {
                    System.out.println("Late");
                    System.out.printf("%d:0%d hours after the start", earlyLateArrivalHours, earlyLateArrivalMinutes);

                }else {
                        System.out.println("Late");
                        System.out.printf("%d:%d hours after the start", earlyLateArrivalHours, earlyLateArrivalMinutes);
                    }
                }
            }
        }