import java.util.Scanner;

public class FuelTankPart2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String fuelType = sc.nextLine().toLowerCase();
        double liters = Double.parseDouble(sc.nextLine());
        String discountCard = sc.nextLine().toLowerCase();

        double gasolinePricePerLiter = 2.22;
        double gasPricePerLiter = 0.93;
        double dieselPricePerLiter = 2.33;

        double gasDiscountPerLiter = 0.08;
        double gasolineDiscountPerLiter = 0.18;
        double dieselDiscountPerLiter = 0.12;

        boolean hasDiscount = discountCard.equalsIgnoreCase("yes");
        boolean isDiesel = fuelType.equalsIgnoreCase("diesel");
        boolean isGas = fuelType.equalsIgnoreCase("gas");
        boolean isGasoline = fuelType.equalsIgnoreCase("gasoline");
        boolean hasChargeBetween20And25 = liters >= 20 && liters <= 25;
        boolean hasChargeMoreThan25 = liters > 25;

        double totalPrice = 0;

        if(hasDiscount){
            if(isDiesel){
                totalPrice = dieselPricePerLiter * liters - (dieselDiscountPerLiter * liters);

                if(hasChargeBetween20And25){
                    totalPrice = totalPrice * 0.92;
                    System.out.printf("%.2f lv.", totalPrice);

                }else if(hasChargeMoreThan25){
                    totalPrice = totalPrice * 0.9;
                    System.out.printf("%.2f lv.", totalPrice);

                } else{
                    System.out.printf("%.2f lv.", totalPrice);

                }
            }else if(isGas){
                totalPrice = gasPricePerLiter * liters - (gasDiscountPerLiter * liters);

                if(hasChargeBetween20And25){
                    totalPrice = totalPrice * 0.92;
                    System.out.printf("%.2f lv.", totalPrice);

                }else if(hasChargeMoreThan25){
                    totalPrice = totalPrice * 0.9;
                    System.out.printf("%.2f lv.", totalPrice);

                }else{
                    System.out.printf("%.2f lv.", totalPrice);

                }
            }else {
                totalPrice = gasolinePricePerLiter * liters - (gasolineDiscountPerLiter * liters);

                if(hasChargeBetween20And25){
                    totalPrice = totalPrice * 0.92;
                    System.out.printf("%.2f lv.", totalPrice);

                }else if(hasChargeMoreThan25){
                    totalPrice = totalPrice * 0.9;
                    System.out.printf("%.2f lv.", totalPrice);

                }else{
                    System.out.printf("%.2f lv.", totalPrice);

                }
            }

        }else{
            if(isDiesel){
                totalPrice = dieselPricePerLiter * liters;

                if(hasChargeBetween20And25){
                    totalPrice = totalPrice * 0.92;
                    System.out.printf("%.2f lv.", totalPrice);

                }else if(hasChargeMoreThan25){
                    totalPrice = totalPrice * 0.9;
                    System.out.printf("%.2f lv.", totalPrice);

                }else{
                    System.out.printf("%.2f lv.", totalPrice);

                }
            }else if(isGas){
                totalPrice = gasPricePerLiter * liters;

                if(hasChargeBetween20And25){
                    totalPrice = totalPrice * 0.92;
                    System.out.printf("%.2f lv.", totalPrice);

                }else if(hasChargeMoreThan25){
                    totalPrice = totalPrice * 0.9;
                    System.out.printf("%.2f lv.", totalPrice);

                }else{
                    System.out.printf("%.2f lv.", totalPrice);

                }
            }else {
                totalPrice = gasolinePricePerLiter * liters;

                if(hasChargeBetween20And25){
                    totalPrice = totalPrice * 0.92;
                    System.out.printf("%.2f lv.", totalPrice);

                }else if(hasChargeMoreThan25){
                    totalPrice = totalPrice * 0.9;
                    System.out.printf("%.2f lv.", totalPrice);

                }else{
                    System.out.printf("%.2f lv.", totalPrice);

                }
            }
        }
    }
}
