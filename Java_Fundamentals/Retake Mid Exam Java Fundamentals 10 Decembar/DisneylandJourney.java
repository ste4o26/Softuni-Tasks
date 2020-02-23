import java.util.Scanner;

public class DisneylandJourney {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double journeyCost = Double.parseDouble(sc.nextLine());
        int numberOfMonths = Integer.parseInt(sc.nextLine());
        double collectedMoney = 0.0;

        for (int i = 1; i <= numberOfMonths; i++) {
            if (i % 4 == 0) {
                collectedMoney += (collectedMoney * 0.25);
            }

            if (i % 2 != 0 && i != 1) {
                collectedMoney *= 0.84;
            }

            double monthAmount = journeyCost * 0.25;
            collectedMoney += monthAmount;
        }

        if (collectedMoney >= journeyCost) {
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.%n", Math.abs(collectedMoney - journeyCost));
        } else {
            System.out.printf("Sorry. You need %.2flv. more.%n", Math.abs(collectedMoney - journeyCost));
        }
    }
}
