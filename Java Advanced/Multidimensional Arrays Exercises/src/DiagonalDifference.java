import java.util.Scanner;

public class DiagonalDifference {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        int cols = rows;
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, sc);
        int primaryDiagonalSum = getPrimaryDiagonalSum(matrix);
        int secondaryDiagonalSum = getSecondaryDiagonalSum(matrix);
        int result = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
        System.out.println(result);
    }

    private static int getSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        int col = 0;
        for (int row = matrix.length - 1; row >= 0 ; row--) {
            sum += matrix[row][col];
            col++;
        }
        return sum;
    }

    private static int getPrimaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        int col = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum += matrix[row][col];
            col++;
        }
        return sum;
    }

    static void fillMatrix(int[][] matrix, Scanner sc){
        for (int row = 0; row < matrix.length; row++) {
            int[] array = matrix[row];
            String[] inputTokens = sc.nextLine().split("\\s+");
            for (int col = 0; col < array.length; col++) {
                array[col] = Integer.parseInt(inputTokens[col]);
            }
        }
    }
}
