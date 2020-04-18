import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        int c = Integer.parseInt(sc.nextLine());
        int d = Integer.parseInt(sc.nextLine());

        int diagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int firstRowFirstNum = a; firstRowFirstNum <= b; firstRowFirstNum++) {
            for (int firstRowSecondNum = a; firstRowSecondNum <= b; firstRowSecondNum++) {
                for (int secondRowFirstNum = c; secondRowFirstNum <= d; secondRowFirstNum++) {
                    for (int secondRowSecondNum = c; secondRowSecondNum <= d; secondRowSecondNum++) {
                        diagonalSum = firstRowFirstNum + secondRowSecondNum;
                        secondaryDiagonalSum = firstRowSecondNum + secondRowFirstNum;
                        if(diagonalSum == secondaryDiagonalSum){
                            if(firstRowFirstNum != firstRowSecondNum && secondRowFirstNum != secondRowSecondNum){
                                System.out.printf("%d%d%n%d%d%n%n", firstRowFirstNum, firstRowSecondNum, secondRowFirstNum, secondRowSecondNum);
                            }
                        }

                    }
                }
            }
        }

    }
}
