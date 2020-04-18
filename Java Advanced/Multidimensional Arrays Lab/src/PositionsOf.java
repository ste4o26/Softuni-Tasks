import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] inputDimensions = sc.nextLine().split("\\s+");
        int rows = Integer.parseInt(inputDimensions[0]);
        int collumns = Integer.parseInt(inputDimensions[1]);
        int[][] multiArray = new int[rows][collumns];
        fillMultiArray(multiArray, sc);

        boolean isPresent = false;
        int number = Integer.parseInt(sc.nextLine());
        for (int row = 0; row < multiArray.length; row++) {
            int[] array = multiArray[row];

            for (int coll = 0; coll < array.length; coll++) {
                int numberAtIndex = array[coll];
                if (numberAtIndex == number){
                    System.out.println(row + " " + coll);
                    isPresent = true;
                }
            }
        }

        if (!isPresent){
            System.out.println("not found");
        }
    }

    static void fillMultiArray(int[][] multiArray, Scanner sc) {
        for (int row = 0; row < multiArray.length; row++) {
            int[] array = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();

            multiArray[row] = array;
        }
    }
}
