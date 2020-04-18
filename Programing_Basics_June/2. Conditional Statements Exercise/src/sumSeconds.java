import java.util.Scanner;

public class sumSeconds {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstRacerTime = Integer.parseInt(sc.nextLine());
        int secondRacerTime = Integer.parseInt(sc.nextLine());
        int tirdRacerTime = Integer.parseInt(sc.nextLine());

        int totalTimeOfAllRacers = firstRacerTime + secondRacerTime + tirdRacerTime;

        int minutes = totalTimeOfAllRacers / 60;
        int seconds = totalTimeOfAllRacers % 60;

        if(seconds < 10){
            System.out.printf("%d:%02d", minutes, seconds);
            //System.out.printf("%d:0%d", minutes, seconds);
        }else {
            System.out.printf("%d:%d", minutes, seconds);

        }
    }
}
