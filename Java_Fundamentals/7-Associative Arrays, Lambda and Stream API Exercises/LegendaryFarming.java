import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> legendaryItems = new TreeMap<String, Integer>();
        Map<String, Integer> junkItems = new TreeMap<String, Integer>();
        fillMaps(legendaryItems, junkItems, sc);
        printSorted(legendaryItems, junkItems);
    }

    static void printSorted(Map<String, Integer> legendaryItems, Map<String, Integer> junkItems){
        legendaryItems
                .entrySet()
                .stream()
                .sorted((value1, value2) -> value2.getValue().compareTo(value1.getValue()))
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

        junkItems
                .entrySet()
                .stream()
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }

    static void fillMaps(Map<String, Integer> legendaryItems, Map<String, Integer> junkItems, Scanner sc) {
        legendaryItems.put("shards", 0);
        legendaryItems.put("fragments", 0);
        legendaryItems.put("motes", 0);
        boolean isObtained = false;

        while (!isObtained) {
            String[] input = sc.nextLine().split("\\s+");
            for (int i = 0; i < input.length; i += 2) {
                String item = input[i + 1].toLowerCase();
                int quantity = Integer.parseInt(input[i]);

                if (legendaryItems.containsKey(item)) {
                    int newQuantity = quantity + legendaryItems.get(item);
                    legendaryItems.put(item, newQuantity);

                    if (legendaryItems.get("shards") >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        legendaryItems.put("shards", legendaryItems.get("shards") - 250);
                        isObtained = true;
                        break;

                    } else if (legendaryItems.get("fragments") >= 250) {
                        System.out.println("Valanyr obtained!");
                        legendaryItems.put("fragments", legendaryItems.get("fragments") - 250);
                        isObtained = true;
                        break;

                    } else if (legendaryItems.get("motes") >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        legendaryItems.put("motes", legendaryItems.get("motes") - 250);
                        isObtained = true;
                        break;
                    }

                } else {
                    if (junkItems.containsKey(item)) {
                        int newQuantity = junkItems.get(item) + quantity;
                        junkItems.put(item, newQuantity);
                    } else {
                        junkItems.put(item, quantity);
                    }
                }
            }
        }
    }
}
