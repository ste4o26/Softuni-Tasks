import java.util.Scanner;

public class Firm {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int hoursNeeded = Integer.parseInt(sc.nextLine());
        int daysThatFirmHave = Integer.parseInt(sc.nextLine());
        int extraordinaryЕmployers = Integer.parseInt(sc.nextLine());

        int workingDay = 8;
        double totalDaysThatFirmHave = daysThatFirmHave * 0.9;
        double totalHoursThatFirmHave = Math.floor((totalDaysThatFirmHave * 8) + (extraordinaryЕmployers * 2 * daysThatFirmHave));

        boolean isTimeEnough = totalHoursThatFirmHave >= hoursNeeded;

        if(isTimeEnough){
            double extraHours = totalHoursThatFirmHave - hoursNeeded;
            System.out.printf("Yes!%.0f hours left.", Math.floor(extraHours));

        }else{
            double hoursToComplete = hoursNeeded - totalHoursThatFirmHave;
            System.out.printf("Not enough time!%.0f hours needed.", Math.floor(hoursToComplete));

        }
    }
}
