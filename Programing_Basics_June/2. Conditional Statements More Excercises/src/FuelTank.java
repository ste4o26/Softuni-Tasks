import java.util.Scanner;

public class FuelTank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //read input
        String fuelType = sc.nextLine().toLowerCase();
        double liters = Double.parseDouble(sc.nextLine());

        boolean isFuelEnough = liters >= 25;
        boolean isDiesel = fuelType.equalsIgnoreCase("diesel");
        boolean isGas = fuelType.equalsIgnoreCase("gas");
        boolean isGasoline = fuelType.equalsIgnoreCase("gasoline");

        if(isFuelEnough){
            if(isDiesel){
                System.out.printf("You have enough %s.", fuelType);

            }else if(isGas){
                System.out.printf("You have enough %s.", fuelType);

            }else if(isGasoline){
                System.out.printf("You have enough %s.", fuelType);

            }else {
                System.out.println("Invalid fuel!");

            }

        }else{
            if(isDiesel){
                System.out.printf("Fill your tank with %s!", fuelType);

            }else if(isGas){
                System.out.printf("Fill your tank with %s!", fuelType);

            }else if(isGasoline){
                System.out.printf("Fill your tank with %s!", fuelType);

            }else {
                System.out.println("Invalid fuel!");

            }
        }
    }
}
