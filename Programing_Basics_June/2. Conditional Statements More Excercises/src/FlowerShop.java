import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

public class FlowerShop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //read input
        int magnoliaQuantity = Integer.parseInt(sc.nextLine());
        int hyacinthsQuantity = Integer.parseInt(sc.nextLine());
        int rosesQuantity = Integer.parseInt(sc.nextLine());
        int cactiQuantity = Integer.parseInt(sc.nextLine());
        double giftPrice = Double.parseDouble(sc.nextLine());

        double perMagnoliaPrice = 3.25;
        int perHyacinthPrice = 4;
        double perRosePrice = 3.50;
        int perCactiPrice = 8;

        double rosesPrice = perRosePrice * rosesQuantity;
        double magnoliaPrice = perMagnoliaPrice * magnoliaQuantity;
        double hyacinthsPrice = perHyacinthPrice * hyacinthsQuantity;
        double cactiPrice = perCactiPrice * cactiQuantity;

        double totalMoneyEarned = rosesPrice + magnoliaPrice + hyacinthsPrice + cactiPrice;
        totalMoneyEarned *= 0.95;

        boolean areMoneyEnough = totalMoneyEarned >= giftPrice;

        if(areMoneyEnough){
            double extraMoney = totalMoneyEarned - giftPrice;
            System.out.printf("She is left with %.0f leva.", Math.floor(extraMoney));

        }else{
            double moneyNeeded = giftPrice - totalMoneyEarned;
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(moneyNeeded));

        }

    }
}
