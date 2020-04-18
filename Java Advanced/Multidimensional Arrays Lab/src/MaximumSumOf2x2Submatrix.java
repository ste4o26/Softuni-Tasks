import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] inputDimensions = sc.nextLine().split(",\\s+");
        int rows = Integer.parseInt(inputDimensions[0]);
        int columns = Integer.parseInt(inputDimensions[1]);
        int[][] multiArray = new int[rows][columns];
        fillMultiArray(multiArray, sc);

        int maxSum = 0;
        findBestSubMultiArray(maxSum, multiArray);
    }

    static void printbestSubArray(int[][] bestSubArray){
        for (int row = 0; row < bestSubArray.length; row++) {
            int[] array = bestSubArray[row];
            for (int coll = 0; coll < array.length; coll++) {
                int currentNumber = array[coll];
                System.out.print(currentNumber + " ");
            }
            System.out.println();
        }
    }

    static void fillMultiArray(int[][] multiArray, Scanner sc) {
        for (int row = 0; row < multiArray.length; row++) {
            int[] array = Arrays.stream(sc.nextLine().split(",\\s+"))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();
            multiArray[row] = array;
        }
    }

    static void findBestSubMultiArray(int maxSum, int[][] multiArray){
        int[][] bestSubMultiArray = new int[2][2];
        for (int row = 0; row < multiArray.length - 2; row++) {
            for (int coll = 0; coll < multiArray[row].length - 2; coll++) {
                int[][] currentSubMultiArray = new int[3][3];
                fillCurrentMultyArray(currentSubMultiArray, multiArray);
                int currentMaxSum = getSumOfCurrentSubMultiArray(currentSubMultiArray);
              /*
                              int[][] currentSubMultiArray = new int[2][2];
                currentSubMultiArray[0][0] = multiArray[row][coll];
                currentSubMultiArray[0][1] = multiArray[row][coll + 1];
                currentSubMultiArray[1][0] = multiArray[row + 1][coll];
                currentSubMultiArray[1][1] = multiArray[row + 1][coll + 1];

                int currentMaxSum = 0;
                for (int subRow = 0; subRow < currentSubMultiArray.length; subRow++) {
                    int[] subArray = currentSubMultiArray[subRow];
                    for (int subColl = 0; subColl < subArray.length; subColl++) {
                        currentMaxSum += subArray[subColl];
                    }
                }*/
                if (currentMaxSum > maxSum){
                    maxSum = currentMaxSum;
                    bestSubMultiArray = currentSubMultiArray;
                }
            }
        }

        printbestSubArray(bestSubMultiArray);
        System.out.println(maxSum);
    }

    static void fillCurrentMultyArray(int[][] submatrix, int[][] matrix){
        for (int subRow = 0; subRow < submatrix.length; subRow++) {
            int[] array = submatrix[subRow];
            for (int subCol = 0; subCol < array.length; subCol++) {
                currentSubMultiArray = matrix[subRow][subCol];
            }
        }
    }

    static int getSumOfCurrentSubMultiArray(int[][] subMultiArray){
        int sum = 0;
        for (int row = 0; row < subMultiArray.length; row++) {
            int[] array = subMultiArray[row];
            for (int col = 0; col < array.length; col++) {
                int currentElement = array[col];
                sum += currentElement;
            }
        }
        return sum;
    }
}
