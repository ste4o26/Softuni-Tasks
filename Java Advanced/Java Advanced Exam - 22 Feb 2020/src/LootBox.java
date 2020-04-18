import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //have to create 2 collections of loot items(integers)
        List<Integer> claimedItems = new ArrayList<>();

        Deque<Integer> firstLootBox = new ArrayDeque<>();//queue;
        String[] tokens = reader.readLine().split("\\s+");
        for (String token : tokens) {
            int item = Integer.parseInt(token);
            firstLootBox.offer(item);
        }

        Deque<Integer> secondLootBox = new ArrayDeque<>();//stack
        tokens = reader.readLine().split("\\s+");
        for (String token : tokens) {
            int item = Integer.parseInt(token);
            secondLootBox.push(item);
        }

        //should stop when one of the given boxes is  empty
        while (!isOneOfBoxesEmpty(firstLootBox, secondLootBox)) {
            //start adding numbers -> first from the first box and last from the second box
            Integer firstBoxLootItem = firstLootBox.peek();
            Integer secondBoxLootItem = secondLootBox.peek();

            int sum = 0;
            if (firstBoxLootItem != null && secondBoxLootItem != null) {
                sum = firstBoxLootItem + secondBoxLootItem;
            }

            //if the sum is even number add it to the third collection of claimed items
            //then remove the values from both collections
            if (isEvenSum(sum)) {
                claimedItems.add(sum);
                firstLootBox.poll();
                secondLootBox.pop();

            } else {
                Integer item = secondLootBox.pop();
                firstLootBox.offer(item);
            }

        }

        //print some messages
        if (isLootBoxEmpty(firstLootBox)) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        int claimedItemsTotalValue = getClaimedItemsTotalValue(claimedItems);
        if (isEpicQualityOfLoot(claimedItemsTotalValue)) {
            System.out.println(String.format("Your loot was epic! Value: %d", claimedItemsTotalValue));
        } else {
            System.out.println(String.format("Your loot was poor... Value: %d", claimedItemsTotalValue));
        }
    }

    private static boolean isEpicQualityOfLoot(int claimedItemsTotalValue) {
        return claimedItemsTotalValue >= 100;
    }

    private static int getClaimedItemsTotalValue(List<Integer> claimedItems) {
        int totalValue = 0;
        for (Integer item : claimedItems) {
            totalValue += item;
        }

        return totalValue;
    }

    private static boolean isEvenSum(int sum) {
        return sum % 2 == 0;
    }

    private static boolean isOneOfBoxesEmpty(Deque<Integer> firstLootBox, Deque<Integer> secondLootBox) {
        return isLootBoxEmpty(firstLootBox) || isLootBoxEmpty(secondLootBox);
    }

    private static boolean isLootBoxEmpty(Deque<Integer> firstLootBox) {
        return firstLootBox.size() == 0;
    }
}
