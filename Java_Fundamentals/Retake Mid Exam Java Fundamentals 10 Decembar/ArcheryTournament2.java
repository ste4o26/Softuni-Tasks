import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArcheryTournament2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> fieldTargetsList = Arrays.stream(sc.nextLine().split("\\|"))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        int iskrenPoints = 0;
        String inputLine = sc.nextLine();
        while (!inputLine.equals("Game over")) {
            String[] tokens = inputLine.split("@");
            String command = tokens[0];

            switch (command) {
                case "Shoot Left":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);

                    while (length > fieldTargetsList.size()) {
                        length -= fieldTargetsList.size();
                    }
                    int targetIndex = Math.abs(fieldTargetsList.size() - (startIndex + length));
                    if (startIndex >= 0 && startIndex < fieldTargetsList.size()) {
                        if (startIndex == 0) {
                            startIndex = fieldTargetsList.size() - 1;
                        }
                        int target = fieldTargetsList.get(targetIndex);
                        if (target < 5) {
                            iskrenPoints += target;
                            fieldTargetsList.set(targetIndex, 0);
                        } else {
                            iskrenPoints += 5;
                            fieldTargetsList.set(targetIndex, target - 5);
                        }
                    }
                    break;

                case "Shoot Right":
                    startIndex = Integer.parseInt(tokens[1]);
                    length = Integer.parseInt(tokens[2]);

                    while (length > fieldTargetsList.size()) {
                        length -= fieldTargetsList.size();
                    }

                    targetIndex = Math.abs(fieldTargetsList.size() - (startIndex + length));
                    if (startIndex >= 0 && startIndex < fieldTargetsList.size()) {
                        if (startIndex == fieldTargetsList.size() - 1) {
                            startIndex = 0;
                        }

                        int target = fieldTargetsList.get(targetIndex);
                        if (target < 5) {
                            iskrenPoints += target;
                            fieldTargetsList.set(targetIndex, 0);
                        } else {
                            iskrenPoints += 5;
                            fieldTargetsList.set(targetIndex, target - 5);
                        }
                    }
                    break;

                case "Reverse":
                    Collections.reverse(fieldTargetsList);
                    break;
            }

            inputLine = sc.nextLine();
        }

        for (int i = 0; i < fieldTargetsList.size(); i++) {
            int currentTarget = fieldTargetsList.get(i);
            if (i == fieldTargetsList.size() - 1) {
                System.out.printf("%d", currentTarget);
            } else {
                System.out.printf("%d - ", currentTarget);
            }
        }
        System.out.println();
        System.out.printf("Iskren finished the archery tournament with %d points!%n", iskrenPoints);
    }
}
