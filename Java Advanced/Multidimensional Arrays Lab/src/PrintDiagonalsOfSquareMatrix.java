import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int inputRows = Integer.parseInt(sc.nextLine());
        int[][] multiArray = new int[inputRows][];
        fillMultiArray(multiArray, sc);
        printFirstDiagonal(multiArray);
        printSecondDiagonal(multiArray);
    }

    static void fillMultiArray(int[][] multiArray, Scanner sc){
        for (int row = 0; row < multiArray.length; row++) {
            int[] array = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            multiArray[row] = array;
        }
    }

    static void printFirstDiagonal(int[][] multiArray){
        for (int row = 0; row < multiArray.length; row++) {
            int[] array = multiArray[row];
            for (int coll = 0; coll < array.length; coll++) {
                if (row == coll){
                    System.out.print(array[coll] + " ");
                }
            }
        }
        System.out.println();
    }

    static void printSecondDiagonal(int[][] multiArray){
        int coll = 0;
        for (int row = multiArray.length - 1; row >= 0; row--) {
            System.out.print(multiArray[row][coll] + " ");
            coll++;
        }
    }
}
