import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] firstDimensions = sc.nextLine().split("\\s+");
        int firstRowsCount = Integer.parseInt(firstDimensions[0]);
        int firstCollCount = Integer.parseInt(firstDimensions[1]);
        int[][] firstMultiArray = new int[firstRowsCount][firstCollCount];
        fillMultiArray(firstMultiArray, sc);

        String[] secondDimensions = sc.nextLine().split("\\s+");
        int secondRowsCount = Integer.parseInt(secondDimensions[0]);
        int secondCollCount = Integer.parseInt(secondDimensions[1]);
        int[][] secondMultiArray = new int[secondRowsCount][secondCollCount];
        fillMultiArray(secondMultiArray, sc);
        boolean areEquals = true;

        if (firstMultiArray.length != secondMultiArray.length || firstCollCount != secondCollCount){
            System.out.println("not equal");
            return;
        }

        for (int row = 0; row < firstMultiArray.length; row++) {
            int[] firstArray = firstMultiArray[row];
            int[] secondArray = secondMultiArray[row];
            for (int i = 0; i < firstArray.length; i++) {
                int firstNumber = firstArray[i];
                int secondNumber = secondArray[i];
                if (firstNumber != secondNumber) {
                    areEquals = false;
                    break;
                }
            }
        }

        if (areEquals) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    static void fillMultiArray(int[][] array, Scanner sc) {
        for (int row = 0; row < array.length; row++) {
            /*int[] coll = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();

              array[row] = coll;
            */
            int[] coll = array[row];
            String[] input = sc.nextLine().split("\\s+");
            for (int i = 0; i < coll.length; i++) {
                coll[i] = Integer.parseInt(input[i]);
            }
        }
    }
}
