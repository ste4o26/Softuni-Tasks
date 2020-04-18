import java.util.Scanner;

public class triangleArea {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double triangleSide = Double.parseDouble(sc.nextLine());
        double triangleHeight = Double.parseDouble(sc.nextLine());


        double triangleArea = (triangleSide * triangleHeight) / 2;

        System.out.printf("%.2f", triangleArea);
    }
}
