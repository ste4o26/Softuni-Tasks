import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, sc);

        String input = sc.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            if (tokens.length != 5 || !"swap".equals(tokens[0])) {
                System.out.println("Invalid input!");
            } else {
                String command = tokens[0];
                int firstElementRow = Integer.parseInt(tokens[1]);
                int firstElementCol = Integer.parseInt(tokens[2]);
                int secondElementRow = Integer.parseInt(tokens[3]);
                int secondElementCol = Integer.parseInt(tokens[4]);

                if ((firstElementRow < 0 || firstElementRow > rows) ||
                        (firstElementCol < 0 || firstElementCol > cols) ||
                        (secondElementRow < 0 || secondElementRow > rows) ||
                        (secondElementCol < 0 || secondElementCol > cols)) {
                    System.out.println("Invalid input!");
                } else {
                    swap(matrix, firstElementRow, firstElementCol, secondElementRow, secondElementCol);
                    printMatrix(matrix);
                }
            }


            input = sc.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] array = matrix[row];
            for (int col = 0; col < array.length; col++) {
                String element = array[col];
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void swap(String[][] matrix, int firstElementRow, int firstElementCol, int secondElementRow, int secondElementCol) {
        String temp = matrix[firstElementRow][firstElementCol];
        matrix[firstElementRow][firstElementCol] = matrix[secondElementRow][secondElementCol];
        matrix[secondElementRow][secondElementCol] = temp;
    }


    private static void fillMatrix(String[][] matrix, Scanner sc) {
        for (int row = 0; row < matrix.length; row++) {
            String[] array = matrix[row];
            String[] inputTokens = sc.nextLine().split("\\s+");
            for (int col = 0; col < array.length; col++) {
                array[col] = inputTokens[col];
            }
        }
    }
}
