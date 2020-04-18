import java.util.Scanner;

public class ReportSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int goalMoney = Integer.parseInt(sc.nextLine());
        int productCounter = 0;
        int cashPayCounter = 0;
        int cardPayCounter = 0;
        int moneySum = 0;
        double payByCahsMoney = 0;
        double payByCardMoney = 0;

        boolean areMoneyEnough = true;

        String isEnd = null;
        int productPrice = 0;

        while (moneySum < goalMoney){

            isEnd = sc.nextLine(); //does not put new line(enter) on last record

            if(isEnd.equals("End")){
                areMoneyEnough = false;
                break;
            }

            productPrice = Integer.parseInt(isEnd);

            if(productCounter % 2 == 0 && productPrice <= 100){
                moneySum += productPrice;
                payByCahsMoney += productPrice;
                System.out.println("Product sold!");
                cashPayCounter++;

            } else if(productCounter % 2 != 0 && productPrice >= 10){
                moneySum += productPrice;
                System.out.println("Product sold!");
                payByCardMoney += productPrice;
                cardPayCounter++;

            } else{
                System.out.println("Error in transaction!");
            }

            productCounter++;

        }

            double avarageCash = payByCahsMoney / cashPayCounter;
            double avarageCard = payByCardMoney / cardPayCounter;

        if(areMoneyEnough){
            System.out.printf("Average CS: %.2f%n", avarageCash);
            System.out.printf("Average CC: %.2f", avarageCard);

        }else{
            System.out.println("Failed to collect required money for charity.");

        }
    }
}
