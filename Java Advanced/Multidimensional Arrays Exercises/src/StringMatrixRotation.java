import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {

    private static char[][] matrix;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] command = sc.nextLine().split("\\(");
        int degrees = Integer.parseInt(command[1].substring(0, command[1].lastIndexOf(")"))) % 360;
        String input = sc.nextLine();
        List<String> inputList = new ArrayList<>();
        System.out.println();
        while (!"END".equals(input)) {
            inputList.add(input);
            input = sc.nextLine();
        }

        int rows = inputList.size();
        int cols = findCols(inputList);
        matrix = new char[rows][cols];
        fillMatrix(matrix, inputList);
        System.out.println();
        printRotatedMatrix(matrix, degrees);

    }

    private static void printRotatedMatrix(char[][] matrix, int degrees) {
        degrees = degrees % 360;
        switch (degrees) {
            case 0:
                for (int row = 0; row < matrix.length; row++) {
                    char[] array = matrix[row];
                    for (int col = 0; col < array.length; col++) {
                        char currentSymbol = array[col];
                        System.out.print(currentSymbol);
                    }
                    System.out.println();
                }
                break;

            case 90:
                int col = 0;
                int row = matrix.length - 1;
                while (col < matrix[row].length) {
                    while (row >= 0) {
                        char currentSymbol = matrix[row][col];
                        System.out.print(currentSymbol);
                        row--;
                    }
                    System.out.println();
                    row = matrix.length - 1;
                    col++;
                }

                break;

            case 180:
                row = matrix.length - 1;
                while (row >= 0) {
                    col = matrix[row].length - 1;
                    while (col >= 0) {
                        char currentSymbol = matrix[row][col];
                        System.out.print(currentSymbol);
                        col--;
                    }
                    System.out.println();
                    row--;
                }
                break;

            case 270:
                row = 0;
                col = matrix[row].length - 1;
                while (col >= 0){
                    while (row < matrix.length){
                        char currentSymbol = matrix[row][col];
                        System.out.print(currentSymbol);
                        row++;
                    }
                    System.out.println();
                    row = 0;
                    col--;
                }
                break;
        }

    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            char[] array = matrix[row];
            for (int col = 0; col < array.length; col++) {
                System.out.print(array[col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(char[][] matrix, List<String> inputList) {
        for (int row = 0; row < matrix.length; row++) {
            char[] array = matrix[row];
            String currentWord = inputList.get(row);
            for (int col = 0; col < array.length; col++) {
                if (col >= currentWord.length()) {
                    array[col] = ' ';
                } else {
                    char currentSymbol = currentWord.charAt(col);
                    array[col] = currentSymbol;
                }
            }
        }
    }

    private static int findCols(List<String> inputList) {
        int biggestStringLength = Integer.MIN_VALUE;
        for (String word : inputList) {
            int currentWordLength = word.length();
            if (currentWordLength > biggestStringLength) {
                biggestStringLength = currentWordLength;
            }
        }
        return biggestStringLength;
    }
}
