import org.omg.CORBA.DataOutputStream;
import org.omg.CORBA.INTERNAL;

import java.util.Scanner;

public class Pets {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //read input
        int daysOut = Integer.parseInt(sc.nextLine());
        int foodLeft = Integer.parseInt(sc.nextLine());//in kilos
        double foodForDog = Double.parseDouble(sc.nextLine());//in kilos
        double foodForCat = Double.parseDouble(sc.nextLine());//in kilos
        double foodForTurtle = Double.parseDouble(sc.nextLine());//in grams

        //calculate how much food will be needed for cat dog and turtle and gather it
        double totalFoodDogNeeds = foodForDog * daysOut;
        double totalFoodCatNeeds = foodForCat * daysOut;
        double totalFoodTurtleNeeds = (foodForTurtle * daysOut) * 0.001;

        double totalFoodNeeded = totalFoodCatNeeds + totalFoodDogNeeds + totalFoodTurtleNeeds;

        boolean isFoodEnough = foodLeft >= totalFoodNeeded;

        if(isFoodEnough){
            double extraFood = foodLeft - totalFoodNeeded;
            System.out.printf("%.0f kilos of food left.", Math.floor(extraFood));

        }else {
            double foodNeeded = totalFoodNeeded - foodLeft;
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(foodNeeded));

        }

    }
}
