import java.util.Scanner;

public class LuggageTax {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int suitcaseWidth = Integer.parseInt(sc.nextLine());
        int suitcaseHeight = Integer.parseInt(sc.nextLine());
        int suitcaseDepth = Integer.parseInt(sc.nextLine());
        boolean isPriority = Boolean.parseBoolean(sc.nextLine());

        double suitcaseVolume = suitcaseDepth * suitcaseHeight * suitcaseWidth;
        double tax = 0.0;

        if (suitcaseVolume > 50) {
            if (isPriority) {
                if (suitcaseVolume > 200) {
                    tax = 20;
                } else if (suitcaseVolume > 100) {
                    tax = 10;
                } else {
                    tax = 0.0;
                }
            } else {
                if (suitcaseVolume > 200) {
                    tax = 100;
                } else if (suitcaseVolume > 100) {
                    tax = 50;
                } else {
                    tax = 25;
                }
            }
        }
        System.out.printf("Luggage tax: %.2f", tax);

    }
}
