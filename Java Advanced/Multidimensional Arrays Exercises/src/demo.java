import java.util.Arrays;
import java.util.Scanner;

public class demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] matrix = new char[5][5];
        fillMatrix(matrix, sc);
        //printMatrix(matrix);
        printMatrixDiagonals(matrix);
        System.out.println("===");
        printMatrixOppositeDiagonal(matrix);
    }

    static void fillMatrix(char[][] matrix, Scanner sc) {
        for (int row = 0; row < matrix.length; row++) {
            String[] input = sc.nextLine().split("\\s+");
            for (int coll = 0; coll < matrix[row].length; coll++) {
                matrix[row][coll] = input[coll].charAt(0);
            }
        }
    }

    static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            char[] array = matrix[row];
            for (int coll = 0; coll < array.length; coll++) {
                char symbol = array[coll];
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }

    static void printMatrixDiagonals(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int row = i;
            int coll = 0;
            while (row >= 0) {
                System.out.print(matrix[row][coll] + " ");
                row--;
                coll++;
            }
            System.out.println();
        }

        for (int i = 1; i < matrix.length; i++) {
            int row = matrix.length - 1;
            int coll = i;
            while (coll < matrix.length) {
                System.out.print(matrix[row][coll] + " ");
                row--;
                coll++;
            }
            System.out.println();
        }
    }

    static void printMatrixOppositeDiagonal(char[][] matrix){
        for (int i = matrix.length - 1; i >= 0; i--) {
            int row = i;
            int coll = 0;
            while (row <= matrix.length - 1){
                System.out.print(matrix[row][coll] + " ");
                row++;
                coll++;
            }
            System.out.println();
        }

        for (int i = 1; i < matrix.length; i++) {
            int row = 0;
            int coll = i;
            while (coll < matrix.length){
                System.out.print(matrix[row][coll] + " ");
                row++;
                coll++;
            }
            System.out.println();
        }
    }
}
