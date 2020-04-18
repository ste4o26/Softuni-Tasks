import java.util.Scanner;

public class BackToThePast {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double inheritanceMoney = Double.parseDouble(sc.nextLine());
        int livingYear = Integer.parseInt(sc.nextLine());
        double yearCost = 0.0;
        int ivanchosYears = 18;
        double totalMoneySpending = 0;

        for (int comebackYear = 1800; comebackYear <= livingYear; comebackYear++) {
            if(comebackYear % 2 == 0){
                yearCost = 12000;
                totalMoneySpending += yearCost;

            }else{
                yearCost = 12000;
                yearCost = yearCost + (50 * ivanchosYears);
                totalMoneySpending += yearCost;

            }
            ivanchosYears++;
        }

        if(totalMoneySpending <= inheritanceMoney){
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", Math.abs(totalMoneySpending - inheritanceMoney));
        }else {
            System.out.printf("He will need %.2f dollars to survive.", Math.abs(totalMoneySpending - inheritanceMoney));
        }
    }
}
