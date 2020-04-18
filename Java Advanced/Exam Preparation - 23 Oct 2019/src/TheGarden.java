import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheGarden {

    private static final String ENDING_COMMAND = "End of Harvest";
    private static final String HARVESTED = " ";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(reader.readLine());
        String[][] garden = new String[rows][];
        fillGardenWithVegetables(reader, garden);

        int carrotsCount = 0;
        int potatoesCount = 0;
        int lettucesCount = 0;
        int harmedVegetables = 0;

        String input = reader.readLine();
        while (!ENDING_COMMAND.equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int rowIndex = Integer.parseInt(tokens[1]);
            int colIndex = Integer.parseInt(tokens[2]);

            if (!isInBounds(rowIndex, colIndex, garden)) {
                input = reader.readLine();
                continue;
            }

            switch (command) {
                case "Harvest":
                    String harvestedVegetable = harvestVegetable(rowIndex, colIndex, garden);
                    switch (harvestedVegetable) {
                        case "L":
                            lettucesCount++;
                            break;

                        case "P":
                            potatoesCount++;
                            break;

                        case "C":
                            carrotsCount++;
                            break;
                    }
                    break;

                case "Mole":
                    String direction = tokens[3];
                    harmedVegetables = mollHarmCells(rowIndex, colIndex, garden, direction, harmedVegetables);
                    break;
            }
            input = reader.readLine();
        }

        printGarden(garden);
        System.out.println("Carrots: " + carrotsCount);
        System.out.println("Potatoes: " + potatoesCount);
        System.out.println("Lettuce: " + lettucesCount);
        System.out.println("Harmed vegetables: " + harmedVegetables);


    }

    private static void printGarden(String[][] garden) {
        for (int row = 0; row < garden.length; row++) {
            for (int col = 0; col < garden[row].length; col++) {
                System.out.print(garden[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static int mollHarmCells(int rowIndex, int colIndex, String[][] garden, String direction, int harmedVegetables) {
        switch (direction) {
            case "up":
                for (int row = rowIndex; row >= 0; row -= 2) {
                    if (harmVegetable(row, colIndex, garden)) {
                        harmedVegetables++;
                    }
                }
                break;

            case "down":
                for (int row = rowIndex; row < garden.length; row += 2) {
                    if (harmVegetable(row, colIndex, garden)) {
                        harmedVegetables++;
                    }
                }
                break;

            case "left":
                for (int col = colIndex; col >= 0; col -= 2) {
                    if (harmVegetable(rowIndex, col, garden)) {
                        harmedVegetables++;
                    }
                }
                break;

            case "right":
                for (int col = colIndex; col < garden[rowIndex].length; col += 2) {
                    if (harmVegetable(rowIndex, col, garden)) {
                        harmedVegetables++;
                    }
                }
                break;
        }
        return harmedVegetables;
    }

    private static boolean harmVegetable(int rowIndex, int colIndex, String[][] garden) {
        if (isInBounds(rowIndex, colIndex, garden)) {
            if (!isHarvested(garden[rowIndex][colIndex])) {
                garden[rowIndex][colIndex] = HARVESTED;
                return true;
            }
        }
        return false;
    }

    private static String harvestVegetable(int rowIndex, int colIndex, String[][] garden) {
        if (isInBounds(rowIndex, colIndex, garden)) {
            if (!isHarvested(garden[rowIndex][colIndex])) {
                String vegetable = garden[rowIndex][colIndex];
                garden[rowIndex][colIndex] = HARVESTED;
                return vegetable;
            }
        }
        return HARVESTED;
    }

    private static boolean isInBounds(int rowIndex, int colIndex, String[][] garden) {
        return (rowIndex >= 0 && rowIndex < garden.length) &&
                (colIndex >= 0 && colIndex < garden[rowIndex].length);
    }

    private static boolean isHarvested(String cell) {
        return cell.equals(HARVESTED);
    }

    private static void fillGardenWithVegetables(BufferedReader reader, String[][] garden) throws IOException {
        for (int row = 0; row < garden.length; row++) {
            garden[row] = Arrays.stream(reader.readLine().split("\\s+"))
                    .toArray(String[]::new);
        }
    }
}
