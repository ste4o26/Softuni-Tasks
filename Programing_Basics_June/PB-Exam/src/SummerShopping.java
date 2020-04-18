import java.util.Scanner;

public class SummerShopping {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //chadyra 2/3 ot cenata na havliqta
        //djapankite 75% ot cenata na chadura
        //chantata 1/3 ot cenata na djapankite + havliqta

        int budget = Integer.parseInt(sc.nextLine());
        double beachTowelPrice = Double.parseDouble(sc.nextLine());
        int discountPercentages = Integer.parseInt(sc.nextLine());

        double beachUmbrellaPrice =  beachTowelPrice * (2.0 / 3.0);
        double flipFlopsPrice = 0.75 * beachUmbrellaPrice;
        double beachBagPrice = (flipFlopsPrice + beachTowelPrice) * (1.00 / 3.00);

        double discount = discountPercentages * 0.01;
        double totalPriceWithoutDiscount = beachBagPrice + beachUmbrellaPrice + beachTowelPrice + flipFlopsPrice;
        double totalPriceWithDiscount = totalPriceWithoutDiscount - (totalPriceWithoutDiscount * discount);
        double moneyRest = Math.abs(budget - totalPriceWithDiscount);

        if(totalPriceWithDiscount <= budget){
            System.out.printf("Annie's sum is %.2f lv. She has %.2f lv. left.", totalPriceWithDiscount, moneyRest);
        }else{
            System.out.printf("Annie's sum is %.2f lv. She needs %.2f lv. more.", totalPriceWithDiscount, moneyRest);
        }
    }
}
