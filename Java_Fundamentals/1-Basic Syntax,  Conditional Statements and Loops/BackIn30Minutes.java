import java.util.Scanner;
public class BackIn30Minutes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hours = Integer.parseInt(sc.nextLine());
        int minutes = Integer.parseInt(sc.nextLine());

        int totalMinutes = minutes + 30 + hours * 60;

        hours = totalMinutes / 60;
        minutes = totalMinutes % 60;

        boolean areMinutesLessThan10 = minutes < 10;
        boolean areHoursAreMoreThan23 = hours > 23;

        if(areMinutesLessThan10) {
            if (areHoursAreMoreThan23) {
                hours = 0;
                System.out.printf("%d:0%d", hours, minutes);
            }else {
                System.out.printf("%d:0%d", hours, minutes);
            }
        }else {
            if(areHoursAreMoreThan23) {
                hours = 0;
                System.out.printf("%d:%d", hours, minutes);
            }else{
                System.out.printf("%d:%d", hours, minutes);
            }
        }
    }
}
