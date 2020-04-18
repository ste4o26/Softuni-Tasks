package jedi_galaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final String END_COMMAND = "Let the Force be with you";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getParsedArray(scanner.nextLine());

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        int value = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = value++;
            }
        }

        String command = scanner.nextLine();
        long sum = 0;
        while (!END_COMMAND.equals(command)) {
            int[] enemyPosition = getParsedArray(scanner.nextLine());
            int enemyRow = enemyPosition[0];
            int enemyCol = enemyPosition[1];

            while (enemyRow >= 0 && enemyCol >= 0) {
                if (enemyRow < matrix.length && enemyCol < matrix[0].length) {
                    matrix[enemyRow][enemyCol] = 0;
                }
                enemyRow--;
                enemyCol--;
            }

            int[] playerPosition = getParsedArray(command);
            int playerRow = playerPosition[0];
            int playerCol = playerPosition[1];

            while (playerRow >= 0 && playerCol < matrix[1].length) {
                if (playerRow < matrix.length && playerCol >= 0 && playerCol < matrix[0].length) {
                    sum += matrix[playerRow][playerCol];
                }
                playerCol++;
                playerRow--;
            }

            command = scanner.nextLine();
        }

        System.out.println(sum);
    }

    private static int[] getParsedArray(String input) {
        return Arrays
                .stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
