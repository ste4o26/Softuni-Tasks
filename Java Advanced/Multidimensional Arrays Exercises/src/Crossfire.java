import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Crossfire {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        List<List<Integer>> matrix = fillMatrix(rows, cols);
        String input = sc.nextLine();

        while (!"Nuke it from orbit".equals(input)) {
            int[] tokens = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int rowIndex = tokens[0];
            int colIndex = tokens[1];
            int radiusOfExplosion = tokens[2];

            destroyCells(matrix, rowIndex, colIndex, radiusOfExplosion);
            for (int row = 0; row < matrix.size(); row++) {
                matrix.set(row, matrix.get(row).stream()
                        .filter(element -> element != 0)
                        .collect(Collectors.toCollection(ArrayList::new)));

                if (matrix.get(row).size() == 0){
                    matrix.remove(row);
                    row--;
                }
            }

            input = sc.nextLine();
        }
        printMatrix(matrix);
    }

    private static void destroyCells(List<List<Integer>> matrix, int rowIndex, int colIndex, int radiusOfExplosion) {
        //destroy bottom and top cells
        for (int row = rowIndex - radiusOfExplosion; row <= rowIndex + radiusOfExplosion; row++) {
            if (isInBounds(matrix, row, colIndex)) {
                List<Integer> list = matrix.get(row);
                list.set(colIndex, 0);
            }
        }

        //destroy left and right cells
        for (int col = colIndex - radiusOfExplosion; col <= colIndex + radiusOfExplosion; col++) {
            if (isInBounds(matrix, rowIndex, col)) {
                List<Integer> list = matrix.get(rowIndex);
                list.set(col, 0);
            }
        }


    }

    private static boolean isInBounds(List<List<Integer>> matrix, int row, int col) {
        return row >= 0
                && row < matrix.size()
                && col >= 0
                && col < matrix.get(row).size();
    }


    private static List<List<Integer>> fillMatrix(int rows, int cols) {
        int count = 1;
        List<List<Integer>> matrix = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                List<Integer> list = matrix.get(row);
                list.add(count);
                count++;
            }
        }
        return matrix;
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            List<Integer> list = matrix.get(row);
            for (int col = 0; col < list.size(); col++) {
                System.out.print(list.get(col) + " ");
            }
            System.out.println();
        }
    }
}
