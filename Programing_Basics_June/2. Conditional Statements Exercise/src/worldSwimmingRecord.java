import java.util.Scanner;

public class worldSwimmingRecord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //1 read input
        //2 water resistance slows him with 12.5 s on every 15 sec
        //3 ivancho's time in sec and difference wetween world record and ivanchos record

        double worldRecord = Double.parseDouble(sc.nextLine());
        double distance = Double.parseDouble(sc.nextLine());
        double timeInSecForOneMeter = Double.parseDouble(sc.nextLine());

        double waterResistance = Math.floor((distance / 15)) * 12.5;

        double totalTimeTofinish = (distance * timeInSecForOneMeter) + waterResistance;

        boolean isIvanchoBrokeWorldRecord = totalTimeTofinish < worldRecord;

        if(isIvanchoBrokeWorldRecord){
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTimeTofinish);

        }else{
            System.out.printf("No, he failed! He was %.2f seconds slower.", Math.abs(worldRecord - totalTimeTofinish));

        }

    }
}
