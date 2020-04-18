import java.util.Scanner;

public class SleepyTomCat {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int daysOff = Integer.parseInt(sc.nextLine());

        int maxMinutesOfPlaying = 30000;
        int daysOffPlayingMins = 127;
        int weekDaysPlayingMins = 63;
        int daysOfYear = 365;

        int totalPlayingMinsInWeekDays = weekDaysPlayingMins * (daysOfYear - daysOff);
        int totalPlayingMinsInDaysOff = daysOff * daysOffPlayingMins;
        int totalMinutesOfPlaying = totalPlayingMinsInDaysOff + totalPlayingMinsInWeekDays;

        int hours = Math.abs((maxMinutesOfPlaying - totalMinutesOfPlaying) / 60);
        int minutes = Math.abs((maxMinutesOfPlaying - totalMinutesOfPlaying) % 60);

        boolean isTomSleepsEnough = maxMinutesOfPlaying > totalMinutesOfPlaying;

        if(isTomSleepsEnough){
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", hours, minutes);

        }else {
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", hours, minutes);

        }
    }
}
