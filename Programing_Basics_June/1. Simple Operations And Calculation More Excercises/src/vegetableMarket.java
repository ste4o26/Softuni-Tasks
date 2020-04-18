import java.util.Scanner;

public class vegetableMarket {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double vagiesPricePerKG = Double.parseDouble(sc.nextLine());
        double fruitsPricePerKG = Double.parseDouble(sc.nextLine());

        int vagiesKG = Integer.parseInt(sc.nextLine());
        int fruitsKG = Integer.parseInt(sc.nextLine());

        double totalMoneyEarnedBGN = (vagiesPricePerKG * vagiesKG) + (fruitsPricePerKG * fruitsKG);
        double totalMoneyEarnedEU = totalMoneyEarnedBGN / 1.94;

        System.out.printf("%.2f", totalMoneyEarnedEU);
    }
}
