import java.util.Scanner;

public class alcoholMarket {

    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            double whiskeyPrice = Double.parseDouble(sc.nextLine());
            double beerAmount = Double.parseDouble(sc.nextLine());
            double wineAmount = Double.parseDouble(sc.nextLine());
            double rakijaAmount = Double.parseDouble(sc.nextLine());
            double whiskeyAmount = Double.parseDouble(sc.nextLine());

            double rakijaPrice = whiskeyPrice * 0.5;
            double winePrice = rakijaPrice - (rakijaPrice * 0.4);
            double beerPrice = rakijaPrice - (rakijaPrice * 0.8);

            double totalWhiskeyPrice = whiskeyAmount * whiskeyPrice;
            double totalBeerPrice = beerAmount * beerPrice;
            double totalWinePrice = wineAmount * winePrice;
            double totalRakijaPrice = rakijaAmount * rakijaPrice;


            double totalMoneyNeeded = totalWhiskeyPrice + totalBeerPrice + totalWinePrice + totalRakijaPrice;

            System.out.printf("%.2f", totalMoneyNeeded);
    }
}
