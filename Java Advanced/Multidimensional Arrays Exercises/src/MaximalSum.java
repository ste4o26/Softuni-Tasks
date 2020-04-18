import java.util.Scanner;

public class MaximalSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] dimensionTokens = sc.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensionTokens[0]);
        int cols = Integer.parseInt(dimensionTokens[1]);
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, sc);
        printBiggestSumOf3x3Matrix(matrix);
    }

    static void printBiggestSumOf3x3Matrix(int[][] matrix) {
        int bestSum = Integer.MIN_VALUE;
        int bestMatrixRow = -1;
        int bestMatrixCol = -1;
        int[][] bestSubMatrix = new int[3][3];
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                //vmesto da imam otdelna matrica i vseki put da q pylnq s elementi i da q sumiram pazq samo indexite
                //kato posle po tqh obhojdam (ot reda i kolonata na nai golqmata suma na matrica 3x3 do reda i kolonata + 3
                // poneje zadachata e s 3x3 matrica)
                int currentMaxSum = getSumOfCurrentSubMatrix(matrix, row, col);
                if (bestSum < currentMaxSum) {
                    bestSum = currentMaxSum;
                    bestMatrixRow = row;
                    bestMatrixCol = col;
                }
            }
        }
        System.out.println("Sum = " + bestSum);
        printMatrix(matrix, bestMatrixRow, bestMatrixCol);
    }

    private static void printMatrix(int[][] matrix, int bestRow, int bestCol) {
        for (int row = bestRow; row < bestRow + 3; row++) {
            int[] array = matrix[row];
            for (int col = bestCol; col < bestCol + 3; col++) {
                int currentElement = array[col];
                System.out.print(currentElement + " ");
            }
            System.out.println();
        }
    }

    static int getSumOfCurrentSubMatrix(/*int[][] subMatrix, */int[][] matrix, int startingRow, int startingCol) {
        int sum = 0;
        for (int row = 0; row < 3; row++) {
            //  int[] array = subMatrix[row];
            for (int col = 0; col < 3; col++) {
                int currentElement = matrix[startingRow + row][startingCol + col];
                sum += currentElement;
            }
        }
        return sum;
    }

    static void fillMatrix(int[][] matrix, Scanner sc) {
        for (int row = 0; row < matrix.length; row++) {
            String[] inputTokens = sc.nextLine().split("\\s+");
            int[] array = matrix[row];
            for (int col = 0; col < array.length; col++) {
                array[col] = Integer.parseInt(inputTokens[col]);
            }
        }
    }
}