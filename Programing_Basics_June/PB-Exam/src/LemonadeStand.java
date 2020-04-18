import java.util.Scanner;

public class LemonadeStand {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //1kg lemons = 980 ml lemon juice
        //pri dobavqne na zaharta  smesta se uvelichava s 30%
        //1 chasha 150 ml
        // kolko chashi e prodala i neinata pechalba
        //1 chasha = 1.20lv

        double lemonsKG = Double.parseDouble(sc.nextLine());
        double sugarKG = Double.parseDouble(sc.nextLine());
        double waterLiters = Double.parseDouble(sc.nextLine());// input is in liters

        int mililitersForOneKGLemons = 980;
        int mililitersInOneCup = 150;
        double priceForOneCup = 1.20;

        double totalMililitersOfLemonJuice = mililitersForOneKGLemons * lemonsKG;
        double totalMililitersOfLemonade = totalMililitersOfLemonJuice + (waterLiters * 1000) + (0.3 * sugarKG);

        double totalCupsSold = Math.floor(totalMililitersOfLemonade / mililitersInOneCup);
        double totalMoneyEarned = totalCupsSold * priceForOneCup;

        System.out.printf("All cups sold: %.0f%n", totalCupsSold);
        System.out.printf("Money earned: %.2f", totalMoneyEarned);
    }
}
