import java.util.Scanner;

public class BachelourParty {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int moneyForMusician = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        int collectedMoney = 0;
        int guestsCounter = 0;


        while (!(input.equals("The restaurant is full"))){
            int groupQuantity = Integer.parseInt(input);
            int couverte = 0;

            if(groupQuantity < 5){
                couverte = 100;
            }else {
                couverte = 70;
            }

            collectedMoney = collectedMoney + (couverte * groupQuantity);
            guestsCounter += groupQuantity;
            input = sc.nextLine();
        }

        int moneyRest = Math.abs(moneyForMusician - collectedMoney);

        if(collectedMoney < moneyForMusician){
            System.out.printf("You have %d guests and %d leva income, but no singer.", guestsCounter, collectedMoney);
        }else{
            System.out.printf("You have %d guests and %d leva left.", guestsCounter, moneyRest);
        }

    }
}
