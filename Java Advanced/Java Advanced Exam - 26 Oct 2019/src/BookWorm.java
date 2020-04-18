import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookWorm {
    private static final String END = "end";
    private static final String UP = "up";
    private static final String DOWN = "down";
    private static final String LEFT = "left";
    private static final String RIGHT = "right";
    private static final String PLAYER = "P";
    private static final String EMPTY = "-";
    private static StringBuilder initialString = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        initialString.append(reader.readLine());
        String[][] field = fillMatrix(reader);

        String command = reader.readLine();
        while (!END.equals(command)) {
            switch (command) {
                case UP:
                    moveUp(field);
                    break;

                case DOWN:
                    moveDown(field);
                    break;

                case LEFT:
                    moveLeft(field);
                    break;

                case RIGHT:
                    moveRight(field);
                    break;
            }


            command = reader.readLine();
        }

        System.out.println(initialString.toString());
        printField(field);
    }

    private static void moveRight(String[][] field) {
        int[] playerCoordinates = getPlayerCoordinates(field);
        int row = playerCoordinates[0];
        int col = playerCoordinates[1] + 1;

        if (!areValidCoordinates(field, row, col)) {
            punishThePlayer();
        } else {
            move(field, row, col);
        }
    }

    private static void moveLeft(String[][] field) {
        int[] playerCoordinates = getPlayerCoordinates(field);
        int row = playerCoordinates[0];
        int col = playerCoordinates[1] - 1;

        if (!areValidCoordinates(field, row, col)) {
            punishThePlayer();
        } else {
            move(field, row, col);
        }
    }

    private static void moveDown(String[][] field) {
        int[] playerCoordinates = getPlayerCoordinates(field);
        int row = playerCoordinates[0] + 1;
        int col = playerCoordinates[1];

        if (!areValidCoordinates(field, row, col)) {
            punishThePlayer();
        } else {
            move(field, row, col);
        }
    }

    private static void moveUp(String[][] field) {
        int[] playerCoordinates = getPlayerCoordinates(field);
        int row = playerCoordinates[0] - 1;
        int col = playerCoordinates[1];

        if (!areValidCoordinates(field, row, col)) {
            punishThePlayer();
        } else {
            move(field, row, col);
        }
    }

    private static void move(String[][] field, int row, int col) {
        int[] playerCoordinates = getPlayerCoordinates(field);
        field[playerCoordinates[0]][playerCoordinates[1]] = EMPTY;

        addLetterToInitialString(field, row, col);

        field[row][col] = PLAYER;
    }

    private static void addLetterToInitialString(String[][] field, int row, int col) {
        if (!field[row][col].equals(EMPTY)) {
            String letter = field[row][col];
            initialString.append(letter);
        }
    }

    private static void punishThePlayer() {
        if (initialString.length() > 0) {
            String replace = initialString.substring(0, initialString.length() - 1);
            initialString.replace(0, initialString.length(), replace);
        }
    }

    private static boolean areValidCoordinates(String[][] field, int row, int col) {
        return (row >= 0 && row < field.length) && (col >= 0 && col < field[row].length);
    }

    private static void printField(String[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }

    private static String[][] fillMatrix(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        String[][] matrix = new String[n][n];
        for (int row = 0; row < matrix.length; row++) {
            String[] inputLine = reader.readLine().split("");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = inputLine[col];
            }
        }

        return matrix;
    }

    private static int[] getPlayerCoordinates(String[][] field) {
        int[] playerCoordinates = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals(PLAYER)) {
                    playerCoordinates[0] = row;
                    playerCoordinates[1] = col;
                }
            }
        }

        return playerCoordinates;
    }

}

