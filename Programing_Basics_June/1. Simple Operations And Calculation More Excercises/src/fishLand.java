import java.util.Scanner;

public class fishLand {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double mackerelPriceKG = Double.parseDouble(sc.nextLine());
        double spratPriceKG = Double.parseDouble(sc.nextLine());

        double sardaQuantity = Double.parseDouble(sc.nextLine());
        double horseMackerelQuantity = Double.parseDouble(sc.nextLine());
        double musselsQuantity = Double.parseDouble(sc.nextLine());

        double sardaPriceKG = mackerelPriceKG * 1.6;
        double horseMackerelPriceKG = spratPriceKG * 1.8;
        double musselsPriceKG = 7.50;

        double totalSardaPrice = sardaQuantity * sardaPriceKG;
        double totalHorseMackerelPrice = horseMackerelQuantity * horseMackerelPriceKG;
        double totalMusselsPrice = musselsQuantity * musselsPriceKG;

        double totalMoneyNeeded = totalHorseMackerelPrice + totalSardaPrice + totalMusselsPrice;

        System.out.printf("%.2f", totalMoneyNeeded);
    }
}
