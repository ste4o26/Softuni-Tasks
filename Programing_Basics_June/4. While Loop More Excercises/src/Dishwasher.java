import java.util.Scanner;

public class Dishwasher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int detergentBottels = Integer.parseInt(sc.nextLine());

        int totalDetergentMililiters = detergentBottels * 750;

        int detergentForOneDish = 5;
        int detergentForOnePot = 15;
        int dishwasherCounter = 0;
        int dishesToWash = 0;
        int clearDishes = 0;
        int clearPots = 0;
        int detergentUsed = 0;

        String end = null;

        boolean isEnough = false;

        while(detergentUsed <= totalDetergentMililiters){

            end = sc.nextLine();

            if(end.equals("End")){
                isEnough = true;
                break;
            }

            dishesToWash = Integer.parseInt(end);
            dishwasherCounter++;

            if(dishwasherCounter % 3 == 0){
                detergentUsed = detergentUsed + (dishesToWash * detergentForOnePot);
                clearPots += dishesToWash;

            }else {
                detergentUsed = detergentUsed + (dishesToWash * detergentForOneDish);
                clearDishes += dishesToWash;

            }
        }

        if(isEnough){
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", clearDishes, clearPots);
            System.out.printf("Leftover detergent %d ml.", totalDetergentMililiters - detergentUsed);

        }else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", detergentUsed - totalDetergentMililiters);

        }
    }
}
