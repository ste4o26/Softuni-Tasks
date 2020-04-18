import java.util.Scanner;

public class charityCamping {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int days = Integer.parseInt(sc.nextLine());
        int coockers = Integer.parseInt(sc.nextLine());
        int cackes = Integer.parseInt(sc.nextLine());
        int wafers = Integer.parseInt(sc.nextLine());
        int pancackes = Integer.parseInt(sc.nextLine());

        double cackePrice = 45;
        double waferPrice = 5.80;
        double pancackePrice = 3.20;

        double totalMoneyEarned = days * (coockers * ((cackes * cackePrice) + (wafers * waferPrice) + (pancackes * pancackePrice)));
        double costs = totalMoneyEarned * 0.125;
        double moneyEarnedForFondation = totalMoneyEarned - costs;

        System.out.printf("%.2f", moneyEarnedForFondation);
    }
}
