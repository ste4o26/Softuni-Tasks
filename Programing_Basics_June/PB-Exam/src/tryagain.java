import java.util.Scanner;

public class tryagain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfPlayers = Integer.parseInt(sc.nextLine());
        String playerName;
        String bakeryName;
        int bakerySum = 0;
        double totalMoneyEarned = 0;
        double cookiePrice = 1.50;
        double cakePrice = 7.80;
        double wafflePrice = 2.30;

        for (int player = 1; player <= numberOfPlayers; player++) {
            playerName = sc.nextLine();
            bakeryName  = sc.nextLine();

            int cookiesQuantity = 0;
            int cakesQuantity = 0;
            int wafflesQuantity = 0;

            while (!(bakeryName.equals("Stop baking!"))) {
                int bakeryQuantity = Integer.parseInt(sc.nextLine());

                switch (bakeryName) {
                    case "cookies":
                        cookiesQuantity += bakeryQuantity;
                        bakerySum += bakeryQuantity;
                        totalMoneyEarned += cookiePrice * bakeryQuantity;
                        break;

                    case "cakes":
                        cakesQuantity += bakeryQuantity;
                        bakerySum += bakeryQuantity;
                        totalMoneyEarned += cakePrice * bakeryQuantity;
                        break;

                    case "waffles":
                        wafflesQuantity += bakeryQuantity;
                        bakerySum += bakeryQuantity;
                        totalMoneyEarned += wafflePrice * bakeryQuantity;
                        break;
                }
                bakeryName = sc.nextLine();
            }

            System.out.printf("%s baked %d cookies, %d cakes and %d waffles.%n", playerName, cookiesQuantity, cakesQuantity, wafflesQuantity);
        }

        System.out.printf("All bakery sold: %d%n", bakerySum);
        System.out.printf("Total sum for charity: %.2f lv.%n", totalMoneyEarned);
    }
}
