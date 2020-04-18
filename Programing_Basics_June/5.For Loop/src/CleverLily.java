import java.util.Scanner;

public class CleverLily {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int lilysYears = Integer.parseInt(sc.nextLine());
        double washingMachinePrice = Double.parseDouble(sc.nextLine());
        int toyPrice = Integer.parseInt(sc.nextLine());

        int moneyPrezent = 0;
        int toyPrezentMoney = 0;
        int brotherSanction = 1;
        double totalMoneyCollected = 0.0;
        int moneyMultiplyer = 1;


        for (int birday = 1; birday <= lilysYears ; birday++) {

            if(birday % 2 == 0){
                moneyPrezent += (10 * moneyMultiplyer) - brotherSanction;
                moneyMultiplyer++;
            }else{
                toyPrezentMoney += toyPrice;
            }
        }

        totalMoneyCollected = moneyPrezent + toyPrezentMoney;

        if(totalMoneyCollected >= washingMachinePrice){
            double moneyLeft = totalMoneyCollected - washingMachinePrice;
            System.out.printf("Yes! %.2f", moneyLeft);
        }else{
            double moneyNeeded = washingMachinePrice - totalMoneyCollected;
            System.out.printf("No! %.2f", moneyNeeded);
        }

    }
}
