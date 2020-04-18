import java.util.Scanner;

public class HotelRoom {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //read input nights, month
        //check the month and do calculation based on the result
        //check the nights and do calculations based on them

        String month = sc.nextLine().toLowerCase();
        int nightsToStay = Integer.parseInt(sc.nextLine());

        double priceForHoleStayInStudio = 0;
        double priceForHoleStayInApartment = 0;

        boolean isMayAndOctober = month.equals("may") || month.equals("october");
        boolean isJuneAndSeptember = month.equals("june") || month.equals("september");
        boolean isJulyAndAugust = month.equals("july") || month.equals("august");

        //conditions for discount for studio
        boolean areMoreThan14NightsForJuneAndSeptember = nightsToStay > 14;
        boolean areMoreThan14NightsForMayAndOctober = nightsToStay > 14;
        boolean areMoreThan7NightsForMayAndOctober = nightsToStay > 7;

        //discount for apartment
        boolean areMoreThan14NightsInApartment = nightsToStay > 14;


        if(isMayAndOctober){
            priceForHoleStayInStudio = 50 * nightsToStay;
            priceForHoleStayInApartment = 65 * nightsToStay;

            if(areMoreThan14NightsForMayAndOctober && areMoreThan14NightsInApartment){
                priceForHoleStayInStudio = priceForHoleStayInStudio * 0.7;
                priceForHoleStayInApartment = priceForHoleStayInApartment * 0.90;

                System.out.printf("Apartment: %.2f lv.\n", priceForHoleStayInApartment);
                System.out.printf("Studio: %.2f lv.", priceForHoleStayInStudio);

            } else if(areMoreThan7NightsForMayAndOctober){
                priceForHoleStayInStudio = priceForHoleStayInStudio * 0.95;

                System.out.printf("Apartment: %.2f lv.\n", priceForHoleStayInApartment);
                System.out.printf("Studio: %.2f lv.", priceForHoleStayInStudio);

            }else{
                System.out.printf("Apartment: %.2f lv.\n", priceForHoleStayInApartment);
                System.out.printf("Studio: %.2f lv.", priceForHoleStayInStudio);

            }

        }else if(isJuneAndSeptember){
            priceForHoleStayInStudio = 75.20 * nightsToStay;
            priceForHoleStayInApartment = 68.70 * nightsToStay;

            if(areMoreThan14NightsForJuneAndSeptember && areMoreThan14NightsInApartment){
                priceForHoleStayInStudio = priceForHoleStayInStudio * 0.80;
                priceForHoleStayInApartment = priceForHoleStayInApartment * 0.90;

                System.out.printf("Apartment: %.2f lv.\n", priceForHoleStayInApartment);
                System.out.printf("Studio: %.2f lv.", priceForHoleStayInStudio);

                }else {
                System.out.printf("Apartment: %.2f lv.\n", priceForHoleStayInApartment);
                System.out.printf("Studio: %.2f lv.", priceForHoleStayInStudio);

            }
        }else if(isJulyAndAugust) {
            priceForHoleStayInStudio = 76 * nightsToStay;
            priceForHoleStayInApartment = 77 * nightsToStay;

            if(areMoreThan14NightsInApartment){
                priceForHoleStayInApartment = priceForHoleStayInApartment * 0.90;
                System.out.printf("Apartment: %.2f lv.\n", priceForHoleStayInApartment);
                System.out.printf("Studio: %.2f lv.", priceForHoleStayInStudio);

            }else {
                System.out.printf("Apartment: %.2f lv.\n", priceForHoleStayInApartment);
                System.out.printf("Studio: %.2f lv.", priceForHoleStayInStudio);

            }
        }
    }
}
