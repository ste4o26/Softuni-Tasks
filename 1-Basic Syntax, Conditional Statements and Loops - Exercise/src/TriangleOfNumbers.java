import java.util.Scanner;
public class TriangleOfNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());

        for (int currentNumber = 1; currentNumber <= number; currentNumber++) {
            for (int i = 1; i <= currentNumber; i++) {
                System.out.printf("%d ",currentNumber);
            }
            System.out.println();
        }
    }
}
