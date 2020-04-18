import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SeashellTreasure {

    private static final char SYMBOL = '-';

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int beachRows = Integer.parseInt(reader.readLine());
        char[][] beach = new char[beachRows][];
        fillBeachWithSeashells(beach, reader);

        List<Character> collectedSeashells = new ArrayList<>();
        int stolenSeashellsCount = 0;
        String inputLine = reader.readLine();
        while (!"Sunset".equals(inputLine)) {
            String[] tokens = inputLine.split("\\s+");
            String command = tokens[0];
            int rowIndex = Integer.parseInt(tokens[1]);
            int colIndex = Integer.parseInt(tokens[2]);

            switch (command) {
                case "Collect":
                    collectSeashell(collectedSeashells, beach, rowIndex, colIndex);
                    break;

                case "Steal":
                    String direction = tokens[3];
                    stolenSeashellsCount = stealSeashells(stolenSeashellsCount, beach, rowIndex, colIndex, direction);
                    break;
            }

            inputLine = reader.readLine();
        }


        displayBeach(beach);
        System.out.print("Collected seashells: " + collectedSeashells.size() + " ");
        StringBuilder sb = new StringBuilder();
        for (char seashell : collectedSeashells) {
            sb.append(seashell + ", ");
        }
        if (!sb.toString().equals("")) {
            System.out.printf("-> %s%n", sb.substring(0, sb.length() - 2));
        }else {
            System.out.println();
        }


        System.out.printf("Stolen seashells: %d%n", stolenSeashellsCount);
    }

    private static void displayBeach(char[][] beach) {
        for (int row = 0; row < beach.length; row++) {
            char[] array = beach[row];
            for (int col = 0; col < array.length; col++) {
                char currentCell = array[col];
                System.out.print(currentCell + " ");
            }
            System.out.println();
        }
    }

    private static int stealSeashells(int stolenSeashellsCount, char[][] beach, int rowIndex, int colIndex, String direction) {
        switch (direction) {
            case "up":
                for (int row = rowIndex; row >= rowIndex - 3; row--) {
                    if (hasSeashellStolen(stolenSeashellsCount, beach, row, colIndex)){
                        stolenSeashellsCount++;
                    }
                }
                break;

            case "down":
                for (int row = rowIndex; row <= rowIndex + 3; row++) {
                    if (hasSeashellStolen(stolenSeashellsCount, beach, row, colIndex)){
                        stolenSeashellsCount++;
                    }
                }
                break;

            case "left":
                for (int col = colIndex; col >= colIndex - 3; col++) {
                    if (hasSeashellStolen(stolenSeashellsCount, beach, rowIndex, col)){
                        stolenSeashellsCount++;
                    }
                }
                break;

            case "right":
                for (int col = colIndex; col <= colIndex + 3; col++) {
                    if (hasSeashellStolen(stolenSeashellsCount, beach, rowIndex, col)){
                        stolenSeashellsCount++;
                    }
                }
                break;
        }

        return stolenSeashellsCount;
    }

    private static boolean isSeashellCollected(char cellValue) {
        return cellValue != SYMBOL;
    }


    private static void collectSeashell(List<Character> seashellsList, char[][] beach, int rowIndex, int colIndex) {
        if (isInBounds(beach, rowIndex, colIndex) && isSeashellCollected(beach[rowIndex][colIndex])) {
            char seashell = beach[rowIndex][colIndex];
            beach[rowIndex][colIndex] = SYMBOL;
            seashellsList.add(seashell);
        }
    }

    private static boolean hasSeashellStolen(int stealShellsCount, char[][] beach, int rowIndex, int colIndex){
        boolean hasStolen = false;
        if (isInBounds(beach, rowIndex, colIndex) && isSeashellCollected(beach[rowIndex][colIndex])) {
            char seashell = beach[rowIndex][colIndex];
            beach[rowIndex][colIndex] = SYMBOL;
            hasStolen = true;
        }
        return hasStolen;
    }
    private static boolean isInBounds(char[][] beach, int rowIndex, int colIndex) {
        return (rowIndex >= 0 && rowIndex < beach.length) && (colIndex >= 0 && colIndex < beach[rowIndex].length);
    }


    private static void fillBeachWithSeashells(char[][] beach, BufferedReader reader) throws IOException {
        for (int row = 0; row < beach.length; row++) {
            String[] inputLine = reader.readLine().split("\\s+");
            char[] array = new char[inputLine.length];

            for (int col = 0; col < array.length; col++) {
                array[col] = inputLine[col].charAt(0);
            }

            beach[row] = array;
        }
    }
}
