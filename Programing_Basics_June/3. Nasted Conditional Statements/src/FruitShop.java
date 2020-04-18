import java.util.Scanner;

public class FruitShop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String fruitName = sc.nextLine().toLowerCase();
        String dayOfWeek = sc.nextLine().toLowerCase();
        double quantity = Double.parseDouble(sc.nextLine());

        double productPrice = 0;

        boolean isWeekEnd = dayOfWeek.equals("saturday") || dayOfWeek.equals("sunday");
        boolean isWeekDay = dayOfWeek.equals("monday") || dayOfWeek.equals("tuesday") || dayOfWeek.equals("wednesday")
                || dayOfWeek.equals("thursday") || dayOfWeek.equals("friday");


        boolean isBanana = fruitName.equals("banana");
        boolean isApple = fruitName.equals("apple");
        boolean isOrange = fruitName.equals("orange");
        boolean isGrapefruit = fruitName.equals("grapefruit");
        boolean isKiwi = fruitName.equals("kiwi");
        boolean isPineapple = fruitName.equals("pineapple");
        boolean isGrapes = fruitName.equals("grapes");


        if (isWeekDay) {

            if (isBanana) {
                productPrice = 2.50 * quantity;
                System.out.printf("%.2f", productPrice);

            } else if (isApple) {
                productPrice = 1.20 * quantity;
                System.out.printf("%.2f", productPrice);

            } else if (isOrange) {
                productPrice = 0.85 * quantity;
                System.out.printf("%.2f", productPrice);

            } else if (isGrapefruit) {
                productPrice = 1.45 * quantity;
                System.out.printf("%.2f", productPrice);

            } else if (isKiwi) {
                productPrice = 2.70 * quantity;
                System.out.printf("%.2f", productPrice);

            } else if (isPineapple) {
                productPrice = 5.50 * quantity;
                System.out.printf("%.2f", productPrice);

            } else if (isGrapes) {
                productPrice = 3.85 * quantity;
                System.out.printf("%.2f", productPrice);

            } else {
                System.out.println("error");
            }

        } else if (isWeekEnd) {

            if (isBanana) {
                productPrice = 2.70 * quantity;
                System.out.printf("%.2f", productPrice);

            } else if (isApple) {
                productPrice = 1.25 * quantity;
                System.out.printf("%.2f", productPrice);

            } else if (isOrange) {
                productPrice = 0.90 * quantity;
                System.out.printf("%.2f", productPrice);

            } else if (isGrapefruit) {
                productPrice = 1.60 * quantity;
                System.out.printf("%.2f", productPrice);

            } else if (isKiwi) {
                productPrice = 3.00 * quantity;
                System.out.printf("%.2f", productPrice);

            } else if (isPineapple) {
                productPrice = 5.60 * quantity;
                System.out.printf("%.2f", productPrice);

            } else if (isGrapes) {
                productPrice = 4.20 * quantity;
                System.out.printf("%.2f", productPrice);
            } else {
                System.out.println("error");
            }

        } else {
            System.out.println("error");
        }
    }
}