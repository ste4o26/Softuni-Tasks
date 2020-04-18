import java.util.Scanner;

public class toyShop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double puzzelPrice = 2.60;
        int dollPrice = 3;
        double teddyBearPrice = 4.10;
        double mignonPrice = 8.20;
        int truckPrice = 2;

        double  excursionPrice = Double.parseDouble(sc.nextLine());
        int numOfPuzzels = Integer.parseInt(sc.nextLine());
        int numOfDolls = Integer.parseInt(sc.nextLine());
        int numOfTeddyBears = Integer.parseInt(sc.nextLine());
        int numOfMignons = Integer.parseInt(sc.nextLine());
        int numOfTrucks = Integer.parseInt(sc.nextLine());

        double totalToysPrice = (numOfPuzzels * puzzelPrice) + (numOfDolls * dollPrice) +
                                + (numOfTeddyBears * teddyBearPrice) + (numOfMignons * mignonPrice) +
                                    +(numOfTrucks * truckPrice);

        int numberOfToys = numOfPuzzels + numOfDolls + numOfTeddyBears + numOfMignons + numOfTrucks;
        boolean areToysMoreThan50 = numberOfToys >= 50;

        double totalMoneyEarned = 0;

        if(areToysMoreThan50){
            double totalToysPriceWithDiscount = totalToysPrice * 0.75;
            totalMoneyEarned = totalToysPriceWithDiscount;

        }else {
            totalMoneyEarned = totalToysPrice;
        }

        totalMoneyEarned = totalMoneyEarned * 0.9;

        boolean areMoneyEnough = totalMoneyEarned >= excursionPrice;

        if(areMoneyEnough){
            double moneyLeft = totalMoneyEarned - excursionPrice;
            System.out.printf("Yes! %.2f lv left.", moneyLeft);

        }else {
            double moneyNeeded = Math.abs(totalMoneyEarned - excursionPrice);
            System.out.printf("Not enough money! %.2f lv needed.", moneyNeeded);
        }
    }
}
