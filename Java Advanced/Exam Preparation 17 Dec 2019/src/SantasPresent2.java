import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SantasPresent2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> boxesWithMaterials = new ArrayDeque<>(); //stack
        fillBoxesWithMaterials(reader, boxesWithMaterials);

        Deque<Integer> magicLevels = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); //queue

        Map<Integer, String> presents = Map.of(150, "Doll",
                250, "Wooden train",
                300, "Teddy bear",
                400, "Bicycle");

        Map<String, Integer> craftedPresents = new TreeMap<>();

        while (!(magicLevels.isEmpty() || boxesWithMaterials.isEmpty())) {
            int magic = magicLevels.peek();
            int material = boxesWithMaterials.peek();

            if (magic == 0 && material == 0) {
                boxesWithMaterials.pop();
                magicLevels.poll();
                continue;
            }
            if (magic == 0) {
                magicLevels.poll();
                continue;
            }
            if (material == 0) {
                boxesWithMaterials.pop();
                continue;
            }


            int totalMagicPower = magic * material;
            if (presents.containsKey(totalMagicPower)) {
                boxesWithMaterials.pop();
                magicLevels.poll();

                String presentName = presents.get(totalMagicPower);
                if (!craftedPresents.containsKey(presentName)) {
                    craftedPresents.put(presentName, 1);
                } else {
                    int newCount = craftedPresents.get(presentName) + 1;
                    craftedPresents.put(presentName, newCount);
                }

            } else {
                if (totalMagicPower < 0) {
                    boxesWithMaterials.pop();
                    magicLevels.poll();
                    int totalMagicPowerSum = magic + material;
                    boxesWithMaterials.push(totalMagicPowerSum);
                } else if (!presents.containsKey(totalMagicPower) && totalMagicPower > 0) {
                    magicLevels.pop();
                    material = boxesWithMaterials.pop();
                    material += 15;
                    boxesWithMaterials.push(material);
                }
            }
        }

        if (arePresentsCrafted(craftedPresents, presents)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        String result = "";
        if (!boxesWithMaterials.isEmpty()) {
            result = String.join(", ", String.valueOf(boxesWithMaterials));
            System.out.println("Materials left: " + result.substring(1, result.length() - 1));
        }

        if (!magicLevels.isEmpty()) {
            result = String.join(", ", String.valueOf(magicLevels));
            System.out.println("Magic left: " + result.substring(1, result.length() - 1));
        }

        craftedPresents
                .forEach((k, v) -> System.out.println(k + ": " + v));
    }

    private static void fillBoxesWithMaterials(BufferedReader reader, Deque<Integer> boxesWithMaterials) throws IOException {
        int[] tokens = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int box : tokens) {
            boxesWithMaterials.push(box);
        }
    }

    private static boolean arePresentsCrafted(Map<String, Integer> craftedPresents, Map<Integer, String> presents) {
        return (craftedPresents.containsKey("Doll") && craftedPresents.containsKey("Wooden train") ||
                (craftedPresents.containsKey("Teddy bear") && craftedPresents.containsKey("Bicycle")));
    }
}
