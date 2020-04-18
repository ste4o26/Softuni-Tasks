import java.util.Scanner;

public class SeaTrip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double kmToTheSea = 210;
        int holidayDurationDays = 3;
        double gazolinePerLiterPrice = 1.85;
        int literCarCost = 7;//liters per 100 km

        double dailyFoodPrice = Double.parseDouble(sc.nextLine());
        double dailySouvenirPrice = Double.parseDouble(sc.nextLine());
        double dailyHotelPrice = Double.parseDouble(sc.nextLine());

        double firstDayHotelPriceDiscount = dailyHotelPrice * 0.90;
        double secondDayHotelPriceDiscount = dailyHotelPrice * 0.85;
        double thirdDayHotelPriceDisocunt = dailyHotelPrice * 0.80;

        double gazolineNeededForTravelingBothWays = (kmToTheSea * 2) / 100 * literCarCost;//multiplying be 100 because of thath the car needs 7 liters per 100 kilos
        double moneyNeededForTravelingBothWays = gazolineNeededForTravelingBothWays * gazolinePerLiterPrice;

        double totalMoneyForFood = dailyFoodPrice * holidayDurationDays;
        double totalMoneyForSouvenirs = dailySouvenirPrice * holidayDurationDays;

        double totalMoneyNeeded = moneyNeededForTravelingBothWays + firstDayHotelPriceDiscount + secondDayHotelPriceDiscount + thirdDayHotelPriceDisocunt + totalMoneyForFood + totalMoneyForSouvenirs;
        System.out.printf("Money needed: %.2f", totalMoneyNeeded);
    }
}
