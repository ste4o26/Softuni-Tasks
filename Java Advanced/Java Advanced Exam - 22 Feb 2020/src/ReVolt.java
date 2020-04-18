import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReVolt {
    private static final String FINISH_MARK = "F";
    private static final String PLAYER_MARK = "f";
    private static final String EMPTY_SLOT = "-";
    private static final String BONUS = "B";
    private static final String TRAP = "T";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int numberOfCommands = Integer.parseInt(reader.readLine());

        String[][] field = new String[n][n];
        fillTheField(field, reader);

        for (int i = 0; i < numberOfCommands; i++) {
            String command = reader.readLine();
            switch (command) {
                case "up":
                    moveUp(field);
                    break;

                case "down":
                    moveDown(field);
                    break;

                case "left":
                    moveLeft(field);
                    break;

                case "right":
                    moveRight(field);
                    break;
            }

            if (isAWinner(field)) {
                break;
            }
        }

        if (isAWinner(field)) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printField(field);
    }

    private static void moveUp(String[][] field) {
        int[] playerCoordinates = getPlayerCoordinates(field);
        int row = playerCoordinates[0] - 1;
        int col = playerCoordinates[1];

        if (!isValidRow(field, row)) {
            row = field.length - 1;
        }

        if (isStepOnTrap(field, row, col)) {
            return;
        }

        if (isStepOnBonus(field, row, col)) {
            row = row - 1;

            if (!isValidRow(field, row)) {
                row = field.length - 1;
            }
        }

        movePlayer(field, playerCoordinates, row, col);
    }

    private static void moveDown(String[][] field) {
        int[] playerCoordinates = getPlayerCoordinates(field);
        int row = playerCoordinates[0] + 1;
        int col = playerCoordinates[1];

        if (!isValidRow(field, row)) {
            row = 0;
        }

        if (isStepOnTrap(field, row, col)) {
            return;
        }

        if (isStepOnBonus(field, row, col)) {
            row = row + 1;

            if (!isValidRow(field, row)) {
                row = 0;
            }
        }

        movePlayer(field, playerCoordinates, row, col);
    }

    private static void moveLeft(String[][] field) {
        int[] playerCoordinates = getPlayerCoordinates(field);
        int row = playerCoordinates[0];
        int col = playerCoordinates[1] - 1;

        if (!isValidCol(field, row, col)) {
            col = field[row].length - 1;
        }

        if (isStepOnTrap(field, row, col)) {
            return;
        }

        if (isStepOnBonus(field, row, col)) {
            col = col - 1;

            if (!isValidCol(field, row, col)) {
                col = field[row].length - 1;
            }
        }


        movePlayer(field, playerCoordinates, row, col);
    }

    private static void moveRight(String[][] field) {
        int[] playerCoordinates = getPlayerCoordinates(field);
        int row = playerCoordinates[0];
        int col = playerCoordinates[1] + 1;

        if (!isValidCol(field, row, col)) {
            col = 0;
        }

        if (isStepOnTrap(field, row, col)) {
            return;
        }

        if (isStepOnBonus(field, row, col)) {
            col = col + 1;

            if (!isValidCol(field, row, col)) {
                col = 0;
            }
        }

        movePlayer(field, playerCoordinates, row, col);
    }

    private static void movePlayer(String[][] field, int[] playerCoordinates, int row, int col) {
        field[playerCoordinates[0]][playerCoordinates[1]] = EMPTY_SLOT;
        field[row][col] = PLAYER_MARK;
    }

    private static boolean isAWinner(String[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals(FINISH_MARK)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isStepOnTrap(String[][] field, int row, int col) {
        return field[row][col].equals(TRAP);
    }

    private static boolean isStepOnBonus(String[][] field, int row, int col) {
        return field[row][col].equals(BONUS);
    }

    private static boolean isValidRow(String[][] field, int row) {
        return row >= 0 && row < field.length;
    }

    private static boolean isValidCol(String[][] field, int row, int col) {
        return col >= 0 && col < field[row].length;
    }


    private static void printField(String[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillTheField(String[][] field, BufferedReader reader) throws IOException {
        for (int row = 0; row < field.length; row++) {
            String[] data = reader.readLine().split("");
            for (int col = 0; col < field[row].length; col++) {
                field[row][col] = data[col];
            }
        }
    }

    private static int[] getPlayerCoordinates(String[][] field) {
        int[] playerCoordinates = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals(PLAYER_MARK)) {
                    playerCoordinates[0] = row;
                    playerCoordinates[1] = col;
                }
            }
        }

        return playerCoordinates;
    }


}
