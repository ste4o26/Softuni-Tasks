import java.util.Scanner;

public class Vacation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double excursionPrice = Double.parseDouble(sc.nextLine());
        double moneyAveilable = Double.parseDouble(sc.nextLine());

        int dayCounter = 0;
        int spendCounter = 0;

        boolean areMoneySpend = false;

        while(moneyAveilable < excursionPrice){
            dayCounter++;

            String option = sc.nextLine();
            double moneySave;
            double moneySpend;

            if(option.equals("save")){
                moneySave = Double.parseDouble(sc.nextLine());
                moneyAveilable += moneySave;
                spendCounter = 0;

            }else{
                moneySpend = Double.parseDouble(sc.nextLine());
                moneyAveilable -= moneySpend;

                if(moneyAveilable < 0){
                    moneyAveilable = 0;
                }

                spendCounter++;

                if(spendCounter >= 5){
                    areMoneySpend = true;
                    break;
                }
            }
        }


        if(!areMoneySpend){
            System.out.printf("You saved the money for %d days.", dayCounter);

        }else {
            System.out.println("You can't save the money.");
            System.out.printf("%d", dayCounter);
        }
    }
}
