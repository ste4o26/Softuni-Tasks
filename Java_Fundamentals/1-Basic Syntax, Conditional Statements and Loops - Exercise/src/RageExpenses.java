import java.util.Scanner;
public class RageExpenses {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int lostGames = Integer.parseInt(sc.nextLine());
        float headsetsPrice = Float.parseFloat(sc.nextLine());
        float mousePrice = Float.parseFloat(sc.nextLine());
        float keyboardPrice = Float.parseFloat(sc.nextLine());
        float displayPrice = Float.parseFloat(sc.nextLine());

        boolean isHeadsetsBroken = false;
        boolean isMouseBroken = false;

        float totalExpenses = 0;
        //1

        int keyboardTrashes = 0;
        for (int numberOfGames = 1; numberOfGames <= lostGames; numberOfGames++) {


            if(numberOfGames % 2 == 0){
                isHeadsetsBroken = true;
                totalExpenses += headsetsPrice;
            }
            if(numberOfGames % 3 == 0){
                isMouseBroken = true;
                totalExpenses += mousePrice;
            }

            if(isMouseBroken && isHeadsetsBroken){
                keyboardTrashes++;
                totalExpenses += keyboardPrice;

                if (keyboardTrashes % 2 == 0){
                    totalExpenses += displayPrice;
                }
            }
            isHeadsetsBroken = false;
            isMouseBroken = false;
        }

        System.out.printf("Rage expenses: %.2f lv.", totalExpenses);
    }
}
