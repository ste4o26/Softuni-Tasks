import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[0]);
        int[][] matrix = new int[rows][cols];
        String command = input[1];
        if (command.equals("A")) {
            fillMatrixPatternA(matrix);
        } else {
            fillMatrixPatternB(matrix);
        }
        printMatrix(matrix);
    }

    static void fillMatrixPatternA(int[][] matrix) {
        int count = 1;
        for (int coll = 0; coll < matrix.length; coll++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][coll] = count;
                count++;
            }
        }
    }

    static void fillMatrixPatternB(int[][] matrix) {
        int count = 1;
        int index = 0;
        for (int coll = 0; coll < matrix.length; coll++) {
            if (index == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][coll] = count;
                    count++;
                    index = row;
                }
            }else if (index == matrix.length - 1){
                for (int row = matrix.length - 1; row >= 0 ; row--) {
                    matrix[row][coll] = count;
                    count++;
                    index = row;
                }
            }
        }
    }


    static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] array = matrix[row];
            Arrays.stream(array)
                    .forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }
}
