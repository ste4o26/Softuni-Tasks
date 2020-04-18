package food_shortage;

import food_shortage.command_manipulator.CitizenCommand;
import food_shortage.command_manipulator.Command;
import food_shortage.command_manipulator.RebelCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static final String END = "End";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Buyer> foodBuyers = new LinkedHashMap<>();
        fillFoodBuyers(reader, foodBuyers);

        System.out.println();

        String inputName = reader.readLine();
        while (!END.equals(inputName)) {
            if (foodBuyers.containsKey(inputName)) {
                Buyer buyer = foodBuyers.get(inputName);
                buyer.buyFood();
            }
            inputName = reader.readLine();
        }

        int totalPurchasedFood = getTotalPurchasedFood(foodBuyers);
        System.out.println(totalPurchasedFood);
    }

    private static int getTotalPurchasedFood(Map<String, Buyer> foodBuyers) {
        int totalFood = 0;
        for (Buyer buyer : foodBuyers.values()) {
            int food = buyer.getFood();
            totalFood += food;
        }
        return totalFood;
    }


    private static void fillFoodBuyers(BufferedReader reader, Map<String, Buyer> foodBuyers) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader
                    .readLine()
                    .split("\\s+");

            Command command;
            if (isCitizen(tokens.length)) {
                command = new CitizenCommand(tokens, foodBuyers);
            } else {
                command = new RebelCommand(tokens, foodBuyers);
            }
            command.execute();
        }
    }

    private static boolean isCitizen(int length) {
        return length == 4;
    }
}
