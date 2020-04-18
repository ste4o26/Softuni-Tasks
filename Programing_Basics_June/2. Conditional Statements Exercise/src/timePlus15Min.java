import java.util.Scanner;

public class timePlus15Min {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int hours = Integer.parseInt(sc.nextLine());
        int minutes = Integer.parseInt(sc.nextLine());

        int bonusMinutes = 15;

        int minutesAfterBonusMin = 0;

        minutesAfterBonusMin = minutes + bonusMinutes;
        boolean isMinutesAfter60 = minutesAfterBonusMin > 59;

        if(isMinutesAfter60){
            minutesAfterBonusMin = minutesAfterBonusMin - 60;
            hours++;
        }

        boolean areHoursAfter23 = hours > 23;
        if(areHoursAfter23){
            hours = 0;

        }

        System.out.printf("%d:%02d", hours, minutesAfterBonusMin);
    }
}
