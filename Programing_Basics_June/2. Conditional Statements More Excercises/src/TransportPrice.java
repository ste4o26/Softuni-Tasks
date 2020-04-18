import java.util.Scanner;

public class TransportPrice {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int kilometers = Integer.parseInt(sc.nextLine());
        String travelingTime = sc.nextLine();

        double bussPricePerKilometer = 0.09;
        double trainPricePerKilometer = 0.06;
        double uberDayPracePerKilometer = 0.79;
        double uberNightPricePerKilometer = 0.90;
        double uberStartPricePerKilometer = 0.70;


        boolean isTrain = kilometers >= 100;
        boolean isBuss = kilometers >= 20;


        if(isTrain){
            double totalTranPrice = trainPricePerKilometer * kilometers;
            System.out.printf("%.2f", totalTranPrice);

        }else if(isBuss){
            double totalBussPrice = bussPricePerKilometer * kilometers;
            System.out.printf("%.2f", totalBussPrice);

        }else{
            double totalUberPrice = 0;

            if(travelingTime.equalsIgnoreCase("day")) {
                totalUberPrice = uberStartPricePerKilometer + (uberDayPracePerKilometer * kilometers);
                System.out.printf("%.2f", totalUberPrice);

            }else {
                totalUberPrice = uberStartPricePerKilometer + (uberNightPricePerKilometer * kilometers);
                System.out.printf("%.2f", totalUberPrice);

            }
        }
    }
}
