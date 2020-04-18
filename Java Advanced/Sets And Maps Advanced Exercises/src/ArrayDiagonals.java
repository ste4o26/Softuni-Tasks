import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayDiagonals {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rows = 3;
        int cols = 4;
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};

        printMatrixDiagonals(matrix, rows, cols);
    }

    private static void printMatrixDiagonals(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            int diagonalRow = i;
            int diagonalCol = 0;

            while (diagonalRow >= 0){
                System.out.print(matrix[diagonalRow][diagonalCol] + " ");
                diagonalRow--;
                diagonalCol++;
            }
            System.out.println();
        }

        for (int i = 1; i < cols; i++) {
            int diagonalRow = matrix.length - 1;
            int diagonalCol = i;
            while (diagonalCol < cols){
                System.out.print(matrix[diagonalRow][diagonalCol] + " ");
                diagonalRow--;
                diagonalCol++;
            }
            System.out.println();
        }

    }
}
