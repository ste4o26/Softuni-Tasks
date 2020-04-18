import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int columns = Integer.parseInt(sc.nextLine());
        char[][] firstMultiArray = new char[rows][columns];
        fillMultiArray(firstMultiArray, sc);

        char[][] secondMultiArray = new char[rows][columns];
        fillMultiArray(secondMultiArray, sc);

        for (int row = 0; row < firstMultiArray.length; row++) {
            char[] firstArray = firstMultiArray[row];
            char[] secondArray = secondMultiArray[row];
            for (int coll = 0; coll < firstArray.length; coll++) {
                char firstArrayCurrentSymbol = firstArray[coll];
                char secondArrayCurrentSymbol = secondArray[coll];

                if (firstArrayCurrentSymbol == secondArrayCurrentSymbol){
                    System.out.print(firstArrayCurrentSymbol + " ");
                }else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    static void fillMultiArray(char[][] multiArray, Scanner sc){
        for (int row = 0; row < multiArray.length; row++) {
            char[] array = new char[multiArray[row].length];
            String[] symbols = sc.nextLine().split("\\s+");
            for (int coll = 0; coll < array.length; coll++) {
                array[coll] = symbols[coll].charAt(0);
            }
            multiArray[row] = array;
        }
    }
}
