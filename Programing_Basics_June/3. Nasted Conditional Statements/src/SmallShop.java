import java.util.Scanner;

public class SmallShop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String stockName = sc.nextLine().toLowerCase();
        String town = sc.nextLine().toLowerCase();
        double quantity = Double.parseDouble(sc.nextLine());

        double coffeePrice = 0;
        double waterPrice = 0;
        double beerPrice = 0;
        double sweetsPrice = 0;
        double peanutsPrice = 0;
        double stockPrice = 0;

        boolean isTownSofia = town.equals("sofia");
        boolean isTownVarna = town.equals("varna");
        boolean isTownPlovdiv = town.equals("plovdiv");

        if (isTownSofia) {

            if (stockName.equals("coffee")) {
                coffeePrice = 0.5;
                stockPrice = coffeePrice * quantity;
                System.out.println(stockPrice);

            } else if (stockName.equals("water")) {
                waterPrice = 0.80;
                stockPrice = waterPrice * quantity;
                System.out.println(stockPrice);

            } else if (stockName.equals("beer")) {
                beerPrice = 1.20;
                stockPrice = beerPrice * quantity;
                System.out.println(stockPrice);

            } else if (stockName.equals("sweets")) {
                sweetsPrice = 1.45;
                stockPrice = sweetsPrice * quantity;
                System.out.println(stockPrice);

            }else {
                peanutsPrice = 1.60;
                stockPrice = peanutsPrice * quantity;
                System.out.println(stockPrice);

            }

        }else if(isTownVarna){
            if (stockName.equals("coffee")) {
                coffeePrice = 0.45;
                stockPrice = coffeePrice * quantity;
                System.out.println(stockPrice);

            } else if (stockName.equals("water")) {
                waterPrice = 0.70;
                stockPrice = waterPrice * quantity;
                System.out.println(stockPrice);

            } else if (stockName.equals("beer")) {
                beerPrice = 1.10;
                stockPrice = beerPrice * quantity;
                System.out.println(stockPrice);

            } else if (stockName.equals("sweets")) {
                sweetsPrice = 1.35;
                stockPrice = sweetsPrice * quantity;
                System.out.println(stockPrice);

            }else {
                peanutsPrice = 1.55;
                stockPrice = peanutsPrice * quantity;
                System.out.println(stockPrice);

            }

        }else if(isTownPlovdiv){

            if (stockName.equals("coffee")) {
                coffeePrice = 0.40;
                stockPrice = coffeePrice * quantity;
                System.out.println(stockPrice);

            } else if (stockName.equals("water")) {
                waterPrice = 0.70;
                stockPrice = waterPrice * quantity;
                System.out.println(stockPrice);

            } else if (stockName.equals("beer")) {
                beerPrice = 1.15;
                stockPrice = beerPrice * quantity;
                System.out.println(stockPrice);

            } else if (stockName.equals("sweets")) {
                sweetsPrice = 1.30;
                stockPrice = sweetsPrice * quantity;
                System.out.println(stockPrice);

            }else {
                peanutsPrice = 1.50;
                stockPrice = peanutsPrice * quantity;
                System.out.println(stockPrice);

            }
        }
    }
}
