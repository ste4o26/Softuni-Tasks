import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PresentDelivery {

    private static final String DASH = "-";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int presentsCount = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        String[][] neighbourhood = new String[n][n];

        fillNeighbourhood(neighbourhood, reader);

        //finding Santa's coordinates
        int niceKidsCount = 0;
        int rowIndexS = -1;
        int colIndexS = -1;
        for (int row = 0; row < neighbourhood.length; row++) {
            for (int col = 0; col < neighbourhood[row].length; col++) {
                if (neighbourhood[row][col].equals("S")) {
                    rowIndexS = row;
                    colIndexS = col;
                }
                if (neighbourhood[row][col].equals("V")) {
                    niceKidsCount++;
                }
            }
        }

        String command = reader.readLine();
        while (!"Christmas morning".equals(command)) {
            neighbourhood[rowIndexS][colIndexS] = DASH;
            switch (command) {
                case "up":
                    //move Santa up
                    rowIndexS--;
                    if (isInBounds(rowIndexS, colIndexS, neighbourhood)) {
                        if (!neighbourhood[rowIndexS][colIndexS].equals(DASH)) {
                            presentsCount = move(presentsCount, neighbourhood, rowIndexS, colIndexS);
                        }
                    }
                    break;

                case "down":
                    rowIndexS++;
                    if (isInBounds(rowIndexS, colIndexS, neighbourhood)) {
                        if (!neighbourhood[rowIndexS][colIndexS].equals(DASH)) {
                            presentsCount = move(presentsCount, neighbourhood, rowIndexS, colIndexS);
                        }
                    }

                    break;

                case "left":
                    colIndexS--;
                    if (isInBounds(rowIndexS, colIndexS, neighbourhood)) {
                        if (!neighbourhood[rowIndexS][colIndexS].equals(DASH)) {
                            presentsCount = move(presentsCount, neighbourhood, rowIndexS, colIndexS);
                        }
                    }
                    break;

                case "right":
                    colIndexS++;
                    if (isInBounds(rowIndexS, colIndexS, neighbourhood)) {
                        if (!neighbourhood[rowIndexS][colIndexS].equals(DASH)) {
                            presentsCount = move(presentsCount, neighbourhood, rowIndexS, colIndexS);
                        }
                    }
                    break;
            }

            if (presentsCount <= 0) {
                break;
            }

            command = reader.readLine();
        }

        neighbourhood[rowIndexS][colIndexS] = "S";

        if (presentsCount <= 0) {
            System.out.println("Santa ran out of presents!");
        }
        printNeighbourhood(neighbourhood);

        int niceKidsWithoutPresentCount = 0;
        for (int row = 0; row < neighbourhood.length; row++) {
            for (int col = 0; col < neighbourhood[row].length; col++) {
                if (neighbourhood[row][col].equals("V")) {
                    niceKidsWithoutPresentCount++;
                }
            }
        }
        if (niceKidsWithoutPresentCount > 0) {
            System.out.printf("No presents for %d nice kid/s.%n", niceKidsWithoutPresentCount);
        } else {
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", niceKidsCount);
        }
    }

    private static int move(int presentsCount, String[][] neighbourhood, int rowIndexS, int colIndexS) {
        if (neighbourhood[rowIndexS][colIndexS].equals("V")) {
            presentsCount--;
            neighbourhood[rowIndexS][colIndexS] = DASH;
        } else if (neighbourhood[rowIndexS][colIndexS].equals("X")) {
            neighbourhood[rowIndexS][colIndexS] = DASH;
        } else if (neighbourhood[rowIndexS][colIndexS].equals("C")) {

            presentsCount = givePresent(rowIndexS - 1, colIndexS, neighbourhood, presentsCount);
            presentsCount = givePresent(rowIndexS + 1, colIndexS, neighbourhood, presentsCount);
            presentsCount = givePresent(rowIndexS, colIndexS - 1, neighbourhood, presentsCount);
            presentsCount = givePresent(rowIndexS, colIndexS + 1, neighbourhood, presentsCount);

            neighbourhood[rowIndexS][colIndexS] = DASH;
            if (presentsCount <= 0) {
                return -1;
            }
        }
        return presentsCount;
    }

    private static int givePresent(int tempRowIndex, int tempColIndex, String[][] neighbourhood, int presentsCount) {
        if (presentsCount <= 0) {
            return -1;
        }

        if (isInBounds(tempRowIndex, tempColIndex, neighbourhood)) {
            if (!neighbourhood[tempRowIndex][tempColIndex].equals(DASH)) {
                presentsCount--;
                neighbourhood[tempRowIndex][tempColIndex] = DASH;
            }
        }
        return presentsCount;
    }

    private static boolean isInBounds(int rowIndexS, int colIndexS, String[][] neighbourhood) {
        return (rowIndexS >= 0 && rowIndexS < neighbourhood.length) &&
                (colIndexS >= 0 && colIndexS < neighbourhood[rowIndexS].length);
    }

    private static void printNeighbourhood(String[][] neighbourhood) {
        for (int row = 0; row < neighbourhood.length; row++) {
            for (int col = 0; col < neighbourhood[row].length; col++) {
                System.out.print(neighbourhood[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillNeighbourhood(String[][] neighbourhood, BufferedReader reader) throws IOException {
        for (int row = 0; row < neighbourhood.length; row++) {
            neighbourhood[row] = Arrays.stream(reader.readLine().split("\\s+"))
                    .toArray(String[]::new);
        }
    }

}
