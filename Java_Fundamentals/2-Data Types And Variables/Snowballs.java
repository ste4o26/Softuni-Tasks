import java.util.Scanner;
public class Snowballs {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfSnowballs = Integer.parseInt(sc.nextLine());

        int maxSnowballValue = Integer.MIN_VALUE;
        int maxSnowballSnow = 0;
        int maxSnowballTime = 0;
        int maxSnowballQuality = 0;

        for (int currentSnowball = 0; currentSnowball < numberOfSnowballs; currentSnowball++) {

            int snowballSnow = Integer.parseInt(sc.nextLine());
            int snowballTime = Integer.parseInt(sc.nextLine());
            int snowballQuality = Integer.parseInt(sc.nextLine());

            int snowballResult = snowballSnow / snowballTime;

            int currentSnowballValue = (int)Math.pow(snowballResult, snowballQuality);

            if(currentSnowballValue > maxSnowballValue){
                maxSnowballValue = currentSnowballValue;
                maxSnowballSnow = snowballSnow;
                maxSnowballTime = snowballTime;
                maxSnowballQuality = snowballQuality;
            }

        }

        
        
        System.out.printf("%d : %d = %d (%d)", maxSnowballSnow, maxSnowballTime, maxSnowballValue, maxSnowballQuality);
    }
}
