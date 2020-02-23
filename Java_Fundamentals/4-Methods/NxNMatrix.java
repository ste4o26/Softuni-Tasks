import java.util.Scanner;
public class NxNMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
        int matrix[][] = new int[number][number];
        //fillMatrix(number, matrix);
        //printMatrix(number, matrix);
        printMatrix(number);
    }
    
    static void fillMatrix(int number, int matrix[][]){
        for (int row = 0; row < number; row++) {
            for (int column = 0; column < number; column++) {
                matrix[row][column] = number;
            }
        }
    }
    
    static void printMatrix(int number, int matrix[][]){
        for (int row = 0; row < number; row++) {
            for (int column = 0; column < number; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    static void printMatrix(int number){
        for (int row = 0; row < number; row++) {
            for (int column = 0; column < number; column++) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
