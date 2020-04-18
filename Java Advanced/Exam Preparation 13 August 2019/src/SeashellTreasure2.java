import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class SeashellTreasure2 {

    private static final String DASH = "-";

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int beachRows = Integer.parseInt(reader.readLine());
        String[][] beach = new String[beachRows][];
        fillBeachWithShells(beach, reader);

        int stolenShells = 0;
        List<String> collectedShells = new LinkedList<>();
        String input = reader.readLine();
        while (!"Sunset".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int rowIndex = Integer.parseInt(tokens[1]);
            int colIndex = Integer.parseInt(tokens[2]);

            switch (command) {
                case "Collect":
                    if (isValidIndex(beach, rowIndex, colIndex)) {
                        String shell = beach[rowIndex][colIndex];
                        if (!isShell(beach[rowIndex][colIndex])) {
                            collectedShells.add(shell);
                            beach[rowIndex][colIndex] = DASH;
                        }
                    }
                    break;

                case "Steal":
                    String direction = tokens[3];
                    if (isValidIndex(beach, rowIndex, colIndex)) {
                        if (!isShell(beach[rowIndex][colIndex])) {
                            stolenShells++;
                            beach[rowIndex][colIndex] = DASH;
                        }
                        stolenShells += moving(beach, rowIndex, colIndex, direction);
                    }
                    break;
            }

            input = reader.readLine();
        }

        printBeach(beach);
        printCollectedSeashells(collectedShells);
        System.out.println("Stolen seashells: " + stolenShells);
    }

    private static void printCollectedSeashells(List<String> collectedShells) {
        System.out.print("Collected seashells: " + collectedShells.size() + " ");
        if (collectedShells.size() != 0) {
            System.out.println("-> " + String.join(", ", collectedShells));
        } else {
            System.out.println();
        }
    }

    private static void printBeach(String[][] beach) {
        for (int row = 0; row < beach.length; row++) {
            for (int col = 0; col < beach[row].length; col++) {
                System.out.print(beach[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int moving(String[][] beach, int rowIndex, int colIndex, String direction) {
        int count = 0;
        switch (direction) {
            case "up":
                for (int row = rowIndex; row >= rowIndex - 3; row--) {
                    count = getCount(beach, colIndex, count, row);
                }
                break;

            case "down":
                for (int row = rowIndex; row <= rowIndex + 3; row++) {
                    count = getCount(beach, colIndex, count, row);
                }
                break;

            case "right":
                for (int col = colIndex; col <= colIndex + 3; col++) {
                    count = getCount(beach, col, count, rowIndex);
                }
                break;

            case "left":
                for (int col = colIndex; col >= colIndex - 3; col--) {
                    count = getCount(beach, col, count, rowIndex);
                }
                break;
        }
        return count;
    }

    private static int getCount(String[][] beach, int col, int count, int row) {
        if (isValidIndex(beach, row, col)) {
            if (!isShell(beach[row][col])) {
                count++;
                beach[row][col] = DASH;
            }
        }
        return count;
    }

    private static boolean isShell(String cellValue) {
        return cellValue.equals(DASH);
    }

    private static boolean isValidIndex(String[][] beach, int row, int col) {
        return (row >= 0 && row < beach.length) && (col >= 0 && col < beach[row].length);
    }

    private static void fillBeachWithShells(String[][] beach, BufferedReader reader) throws IOException {
        for (int row = 0; row < beach.length; row++) {
            beach[row] = reader.readLine().split("\\s+");
        }
    }
}
