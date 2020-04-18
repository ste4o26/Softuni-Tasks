import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        String[][] matrix = new String[rows][cols];
        fillMatrixWithLetters(matrix);
        printMatrix(matrix);
    }

    static void printMatrix(String[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            String[] array = matrix[row];
            for (int col = 0; col < array.length; col++) {
                String element = array[col];
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }


    static void fillMatrixWithLetters(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            char startingAndEndingLetter = (char) (97 + row);
            String[] array = matrix[row];
            for (int col = 0; col < array.length; col++) {
                char middleLetter = (char)(startingAndEndingLetter + col);
                StringBuilder sb = new StringBuilder();
                sb.append(startingAndEndingLetter).append(middleLetter).append(startingAndEndingLetter);
                String result = sb.toString();
                array[col] = result;
            }
        }
    }


}
