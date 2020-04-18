import java.util.Scanner;

public class Coins2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int oneCent = 1;
        int twoCents = 2;
        int fiveCents = 5;
        int tenCents = 10;
        int twentyCents = 20;
        int fiftyCent = 50;
        int oneLev = 100;
        int twoLeva = 200;

        int coinsCounter = 0;

        double change = Double.parseDouble(sc.nextLine()) * 100; //multiply by 100 to convert it into whole number


        //from whole change i subtract price and check if the price becomes 0.
        //if its less than zero the change does not contain the coin we are checking for
        //if its greater we subtract the price and collect it back into change

        while (change - twoLeva >= 0){
            change -= twoLeva;
            coinsCounter++;

        } while (change - oneLev >= 0){
            change -= oneLev;
            coinsCounter++;

        } while (change - fiftyCent >= 0){
            change -= fiftyCent;
            coinsCounter++;

        } while (change - twentyCents >= 0){
            change -= twentyCents;
            coinsCounter++;

        } while (change - tenCents >= 0){
            change -= tenCents;
            coinsCounter++;

        } while (change - fiveCents >= 0){
            change -= fiveCents;
            coinsCounter++;

        } while (change - twoCents >= 0){
            change -= twoCents;
            coinsCounter++;

        } while (change - oneCent >= 0){
            change -= oneCent;
            coinsCounter++;

        }

        System.out.println(coinsCounter);
    }
}
