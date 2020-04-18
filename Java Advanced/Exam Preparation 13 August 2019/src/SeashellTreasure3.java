import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

// THE CORRECT SOLUTION!!!!!!

public class SeashellTreasure3 {
    private static final String SYMBOL = "-";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int beachRows = Integer.parseInt(reader.readLine());
        String[][] beach = new String[beachRows][];
        fillBeachWithSeashells(beach, reader);

        List<String> collectedSeashells = new LinkedList<>();
        List<String> stolenSeashells = new LinkedList<>();
        String inputLine = reader.readLine();
        while (!"Sunset".equals(inputLine)) {
            String[] tokens = inputLine.split(" ");
            String command = tokens[0];
            int rowIndex = Integer.parseInt(tokens[1]);
            int colIndex = Integer.parseInt(tokens[2]);

            switch (command) {
                case "Collect":
                    collectSeashell(collectedSeashells, beach, rowIndex, colIndex);
                    break;

                case "Steal":
                    String direction = tokens[3];
                    stealSeashells(stolenSeashells, beach, rowIndex, colIndex, direction);
                    break;
            }

            inputLine = reader.readLine();
        }


        displayBeach(beach);

        System.out.print("Collected seashells: " + collectedSeashells.size() + " ");
        if (collectedSeashells.size() != 0){
            System.out.println("-> " + String.join(", ", collectedSeashells));
        }else {
            System.out.println();
        }
        System.out.println("Stolen seashells: " + stolenSeashells.size());
    }

    private static void displayBeach(String[][] beach) {
        for (int row = 0; row < beach.length; row++) {
            for (int col = 0; col < beach[row].length; col++) {
                System.out.print(beach[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void stealSeashells(List<String> stolenSeashells, String[][] beach, int rowIndex, int colIndex, String direction) {
        switch (direction) {
            case "up":
                for (int row = rowIndex; row >= rowIndex - 3; row--) {
                    collectSeashell(stolenSeashells, beach, row, colIndex);
                }
                break;

            case "down":
                for (int row = rowIndex; row <= rowIndex + 3; row++) {
                    collectSeashell(stolenSeashells, beach, row, colIndex);
                }
                break;

            case "left":
                for (int col = colIndex; col >= colIndex - 3; col++) {
                    collectSeashell(stolenSeashells, beach, rowIndex, col);
                }
                break;

            case "right":
                for (int col = colIndex; col <= colIndex + 3; col++) {
                    collectSeashell(stolenSeashells, beach, rowIndex, col);
                }
                break;
        }
    }

    private static boolean isSeashellCollected(String cellValue) {
        return !cellValue.equals(SYMBOL);
    }


    private static void collectSeashell(List<String> seashellsList, String[][] beach, int rowIndex, int colIndex) {
        if (isInBounds(beach, rowIndex, colIndex) && isSeashellCollected(beach[rowIndex][colIndex])) {
            String seashell = beach[rowIndex][colIndex];
            beach[rowIndex][colIndex] = SYMBOL;
            seashellsList.add(seashell);
        }
    }

    private static boolean isInBounds(String[][] beach, int rowIndex, int colIndex) {
        return (rowIndex >= 0 && rowIndex < beach.length) && (colIndex >= 0 && colIndex < beach[rowIndex].length);
    }


    private static void fillBeachWithSeashells(String[][] beach, BufferedReader reader) throws IOException {
        for (int row = 0; row < beach.length; row++) {
            beach[row] = reader.readLine().split("\\s+");
        }
    }
}
