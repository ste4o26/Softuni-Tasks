import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] inputDimensions = sc.nextLine().split(",\\s+");
        int rows = Integer.parseInt(inputDimensions[0]);
        int columns = Integer.parseInt(inputDimensions[1]);
        int[][] multiArray = new int[rows][columns];
        fillMultiArray(multiArray, sc);

        System.out.println(rows);
        System.out.println(columns);
        int sum = 0;
        for (int row = 0; row < multiArray.length; row++) {
            int[] array = multiArray[row];
            for (int coll = 0; coll < array.length; coll++) {
                int currentNumber = array[coll];
                sum += currentNumber;
            }
        }
        System.out.println(sum);
    }

    static void fillMultiArray(int[][] multiArray, Scanner sc){
        for (int row = 0; row < multiArray.length; row++) {
            int[] array = Arrays.stream(sc.nextLine().split(",\\s+"))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();
            multiArray[row] = array;
        }
    }
}
