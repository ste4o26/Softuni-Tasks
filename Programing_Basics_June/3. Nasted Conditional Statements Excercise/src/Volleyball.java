import java.util.Scanner;

public class Volleyball {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //read data
        String yearType = sc.nextLine().toLowerCase();
        int numberOfHolidays = Integer.parseInt(sc.nextLine());
        int numberOfWeekendsTravelingHome = Integer.parseInt(sc.nextLine());

        //check if the year is leap if it is 15% more playing volleyball
        boolean isLeapYear = yearType.equalsIgnoreCase("leap");

        //check how many weekends he isnt working
        int weekendsInOneYear = 48;

        //check how many times he plays in sofia : every saturday when he isnt working or going back home, 2/3 holidays

        double sofiaWeekends = weekendsInOneYear - numberOfWeekendsTravelingHome;//
        double sofiaPlayingTimes = sofiaWeekends * (3.0 / 4);
        double holidaysPlayingTime = numberOfHolidays * (2.0 / 3);

        double totalPlayingTimes = sofiaPlayingTimes + holidaysPlayingTime + numberOfWeekendsTravelingHome;

        if (isLeapYear) {
            totalPlayingTimes = totalPlayingTimes + (totalPlayingTimes * 0.15);
            System.out.printf("%.0f", Math.floor(totalPlayingTimes));

        } else {
            System.out.printf("%.0f", Math.floor(totalPlayingTimes));

        }
    }
}
