import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, sc);
        printDiagonals(matrix, rows, cols);
    }

    private static void printDiagonals(int[][] matrix, int rows, int cols) {
        int row = rows - 1;
        int col = cols - 1;
        while (row >= 0) {
            if (col <= -1){
                col = 0;
                row--;
            }
            int r = row;
            int c = col;

            while (c < cols && r >= 0) {
                System.out.print(matrix[r][c] + " ");
                c++;
                r--;
            }
            System.out.println();
            col--;
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner sc) {
        for (int row = 0; row < matrix.length; row++) {
            int[] array = matrix[row];
            int[] inputTokens = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < array.length; col++) {
                array[col] = inputTokens[col];
            }
        }
    }
}
