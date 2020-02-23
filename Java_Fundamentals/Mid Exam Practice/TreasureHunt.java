import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> chestInitialLoot = Arrays.asList(sc.nextLine().split("\\|"));
        List<String> chestStorage = new ArrayList<>();

        chestStorage.addAll(chestInitialLoot);
        //List<String> chestStorage = new ArrayList<>(chestInitialLoot); same As above

        String inputLine = sc.nextLine();
        while (!inputLine.equals("Yohoho!")) {
            String[] tokens = inputLine.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                        if (!chestStorage.contains(tokens[i])) {
                            chestStorage.add(0, tokens[i]);
                        }
                    }
                    break;

                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < chestStorage.size()) {
                        String lootToExchange = chestStorage.get(index);
                        chestStorage.remove(index);
                        chestStorage.add(lootToExchange);
                    }
                    break;

                case "Steal":
                    int stoleItemsCount = Integer.parseInt(tokens[1]);
                    if (stoleItemsCount >= chestStorage.size()) {
                        System.out.println(String.join(", ", chestStorage));
                        chestStorage.clear();
                    } else {
                        List<String> stolenItems = new ArrayList<>();
                        while (stoleItemsCount > 0) {
                            stolenItems.add(chestStorage.get(chestStorage.size() - stoleItemsCount));
                            chestStorage.remove(chestStorage.size() - stoleItemsCount);
                            stoleItemsCount--;
                        }
                        System.out.println(String.join(", ", stolenItems));
                    }
                    break;
            }
            inputLine = sc.nextLine();
        }

        double totalTreasureSum = 0;
        for (int i = 0; i < chestStorage.size(); i++) {
            totalTreasureSum += chestStorage.get(i).length();
        }

        if (!chestStorage.isEmpty()) {
            double averageTreasure = totalTreasureSum / chestStorage.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.%n", averageTreasure);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}