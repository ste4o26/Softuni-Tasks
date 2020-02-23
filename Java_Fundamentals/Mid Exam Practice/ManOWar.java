import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> pirateShip = Arrays.stream(sc.nextLine().split(">"))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        List<Integer> warShip = Arrays.stream(sc.nextLine().split(">"))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        int maxHealthCapacity = Integer.parseInt(sc.nextLine());
        String inputLine = sc.nextLine();
        boolean isEnd = false;
        while (!inputLine.equals("Retire")) {
            String[] tokens = inputLine.split(" ");
            String command = tokens[0];
            int damage = 0;
            int healthAfterDamage = 0;
            switch (command) {
                case "Fire":
                    int index = Integer.parseInt(tokens[1]);
                    damage = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < warShip.size()) {
                        healthAfterDamage = warShip.get(index) - damage;
                        if (healthAfterDamage <= 0) {
                            warShip.set(index, 0);
                            System.out.println("You won! The enemy ship has sunken.");
                            isEnd = true;
                        } else {
                            warShip.set(index, healthAfterDamage);
                        }
                    }
                    break;

                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    damage = Integer.parseInt(tokens[3]);
                    if ((startIndex >= 0 && startIndex < pirateShip.size()) && (endIndex >= 0 && endIndex < pirateShip.size())) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            healthAfterDamage = pirateShip.get(i) - damage;
                            if (healthAfterDamage <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                pirateShip.set(i, 0);
                                isEnd = true;
                                break;
                            } else {
                                pirateShip.set(i, healthAfterDamage);
                            }
                        }
                    }
                    break;

                case "Repair":
                    index = Integer.parseInt(tokens[1]);
                    int health = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < pirateShip.size()) {
                        int healthAfterRepair = health + pirateShip.get(index);
                        if (healthAfterRepair > maxHealthCapacity) {
                            healthAfterRepair = maxHealthCapacity;
                        }
                        pirateShip.set(index, healthAfterRepair);
                    }
                    break;

                case "Status":
                    int count = 0;
                    for (int i = 0; i < pirateShip.size(); i++) {
                        boolean isForRepair = pirateShip.get(i) < (maxHealthCapacity * 0.2);
                        if (isForRepair) {
                            count++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", count);
                    break;
            }

            if (isEnd) {
                break;
            }

            inputLine = sc.nextLine();
        }

        if (!isEnd) {
            int pirateShipStatus = pirateShip
                    .stream()
                    .mapToInt(e -> e)
                    .sum();
            System.out.printf("Pirate ship status: %d%n", pirateShipStatus);

            int warShipStatus = warShip
                    .stream()
                    .mapToInt(e -> e)
                    .sum();
            System.out.printf("Warship status: %d%n", warShipStatus);
        }
    }
}
