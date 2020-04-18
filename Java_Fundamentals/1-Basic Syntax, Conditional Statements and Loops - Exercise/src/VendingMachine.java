import java.util.Scanner;
public class VendingMachine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        double totalMoney = 0;

        while (!word.equals("Start")){
            double coins = Double.parseDouble(word);
            coins *= 100;

            switch ((int)coins){
                case 10 : totalMoney += 0.1; break;
                case 20 : totalMoney += 0.2; break;
                case 50 : totalMoney += 0.5; break;
                case 100 : totalMoney += 1; break;
                case 200 : totalMoney += 2; break;
                default:
                    System.out.printf("Cannot accept %.2f%n", coins/100); break;
            }
            word = sc.nextLine();
        }

        String productName = sc.nextLine();

        while (!productName.equals("End")){
            double productPrice = 0;

            switch (productName){
                case "Nuts" : productPrice = 2.0; break;
                case "Water" : productPrice = 0.7; break;
                case "Crisps" : productPrice = 1.5; break;
                case "Soda" : productPrice = 0.8; break;
                case "Coke" : productPrice = 1.0; break;
                default:
                    System.out.println("Invalid product"); break;
            }

            boolean isProductInTheList = productName.equals("Nuts") || productName.equals("Water") ||
                    productName.equals("Crisps") || productName.equals("Soda") || productName.equals("Coke");


            if(productPrice > totalMoney && isProductInTheList){
                System.out.println("Sorry, not enough money");
            }else if(isProductInTheList){
                totalMoney -= productPrice;
                System.out.printf("Purchased %s%n", productName);
            }

            productName = sc.nextLine();
        }

        System.out.printf("Change: %.2f%n", totalMoney);
    }
}
