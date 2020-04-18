import java.util.Scanner;

public class NewHouse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //read input
        //check the type of flower
        //calculate all discounts

        String flowerType = sc.nextLine();
        int numberOfFlowers = Integer.parseInt(sc.nextLine());
        int budget = Integer.parseInt(sc.nextLine());

        boolean isRose = flowerType.equals("Roses");
        boolean isDahlia = flowerType.equals("Dahlias");
        boolean isTulips = flowerType.equals("Tulips");
        boolean isNarcissus = flowerType.equals("Narcissus");
        boolean isGladiolus = flowerType.equals("Gladiolus");

        double totalPriceWithDscount = 0;

        boolean areRosesMoreThan80 = numberOfFlowers > 80;
        boolean areDahliasMoreThan90 = numberOfFlowers > 90;
        boolean areTulipusMoreThan80 = numberOfFlowers > 80;
        boolean areNarcissusLessThan120 = numberOfFlowers < 120;
        boolean areGladiolusLessThan80 = numberOfFlowers < 80;


        if (isRose) {
            totalPriceWithDscount = numberOfFlowers * 5;

            if (areRosesMoreThan80) {
                totalPriceWithDscount = totalPriceWithDscount * 0.9;

            }
        } else if (isDahlia) {
            totalPriceWithDscount = numberOfFlowers * 3.80;

            if (areDahliasMoreThan90) {
                totalPriceWithDscount = totalPriceWithDscount * 0.85;

            }

        } else if (isTulips) {
            totalPriceWithDscount = numberOfFlowers * 2.80;

            if (areTulipusMoreThan80) {
                totalPriceWithDscount = totalPriceWithDscount * 0.85;
            }

        } else if (isNarcissus) {
            totalPriceWithDscount = numberOfFlowers * 3;

            if (areNarcissusLessThan120) {
                totalPriceWithDscount = totalPriceWithDscount + totalPriceWithDscount * 0.15;
            }

        } else if (isGladiolus) {
            totalPriceWithDscount = numberOfFlowers * 2.50;

            if (areGladiolusLessThan80) {
                totalPriceWithDscount = totalPriceWithDscount + totalPriceWithDscount * 0.2;
            }
        }


        if(totalPriceWithDscount <= budget){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", numberOfFlowers, flowerType, Math.abs(totalPriceWithDscount - budget));

        }else {
            System.out.printf("Not enough money, you need %.2f leva more.", Math.abs(totalPriceWithDscount - budget));
        }
    }
}
