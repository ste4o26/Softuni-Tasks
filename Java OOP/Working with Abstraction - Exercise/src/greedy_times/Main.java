package greedy_times;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long inputTreasure = Long.parseLong(scanner.nextLine());
        String[] tokens = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> treasure = new LinkedHashMap<>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < tokens.length; i += 2) {
            String treasureName = tokens[i];
            long treasureCount = Long.parseLong(tokens[i + 1]);

            String command = getCommand(treasureName);

            long currentTotalTreasureCount = treasure
                    .values()
                    .stream()
                    .map(Map::values)
                    .flatMap(Collection::stream)
                    .mapToLong(e -> e)
                    .sum() + treasureCount;

            if (command.equals("") || inputTreasure < currentTotalTreasureCount) {
                continue;
            }

            switch (command) {
                case "Gem":
                    if (!treasure.containsKey(command)) {
                        if (treasure.containsKey("Gold")) {
                            if (treasureCount > getGoldCount(treasure, "Gold")) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (getTotalTreasureCount(treasure, treasureCount, command) > getGoldCount(treasure, "Gold")) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!treasure.containsKey(command)) {
                        if (treasure.containsKey("Gem")) {
                            if (treasureCount > getGoldCount(treasure, "Gold")) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (getTotalTreasureCount(treasure, treasureCount, command) > getGoldCount(treasure, "Gem")) {
                        continue;
                    }
                    break;
            }

            if (!treasure.containsKey(command)) {
                treasure.put((command), new LinkedHashMap<>());
            }

            if (!treasure.get(command).containsKey(treasureName)) {
                treasure.get(command).put(treasureName, 0L);
            }


            treasure
                    .get(command)
                    .put(treasureName, treasure.get(command).get(treasureName) + treasureCount);
            if (command.equals("Gold")) {
                gold += treasureCount;
            } else if (command.equals("Gem")) {
                gems += treasureCount;
            } else if (command.equals("Cash")) {
                cash += treasureCount;
            }
        }

        for (var x : treasure.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static long getGoldCount(Map<String, LinkedHashMap<String, Long>> treasure, String gold) {
        return treasure.get(gold).values().stream().mapToLong(e -> e).sum();
    }

    private static long getTotalTreasureCount(Map<String, LinkedHashMap<String, Long>> treasure, long treasureCount, String command) {
        return getGoldCount(treasure, command) + treasureCount;
    }

    private static String getCommand(String treasureName) {
        String command = "";
        if (treasureName.length() == 3) {
            command = "Cash";
        } else if (treasureName.toLowerCase().endsWith("gem")) {
            command = "Gem";
        } else if (treasureName.toLowerCase().equals("gold")) {
            command = "Gold";
        }
        return command;
    }
}
