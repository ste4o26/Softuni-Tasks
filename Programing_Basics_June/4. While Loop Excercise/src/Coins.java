import java.util.Scanner;

public class Coins {

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

        double change = Double.parseDouble(sc.nextLine()) * 100;

        double currentChange = 0.0;

        int centsCounts = 0;
        //i need to devide the change

        while (currentChange + twoLeva <= change){
            currentChange += twoLeva;
            centsCounts++;

        } while (currentChange + oneLev <= change){
            currentChange += oneLev;
            centsCounts++;

        }
        while (currentChange + fiftyCent <= change){
            currentChange += fiftyCent;
            centsCounts++;

        }
        while (currentChange + twentyCents <= change){
            currentChange += twentyCents;
            centsCounts++;

        }
        while (currentChange + tenCents <= change){
            currentChange += tenCents;
            centsCounts++;

        }
        while (currentChange + fiveCents <= change){
            currentChange += fiveCents;
            centsCounts++;

        } while (currentChange + twoCents <= change){
            currentChange += twoCents;
            centsCounts++;

        }
        while (currentChange + oneCent <= change){
            currentChange += oneCent;
            centsCounts++;

        }

        System.out.println(centsCounts);
    }
}