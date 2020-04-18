import java.util.Scanner;

public class rectangleArea2D {

    public static void main(String[] args){

            Scanner sc = new Scanner(System.in);

            double x1 = Double.parseDouble(sc.nextLine());
            double y1 = Double.parseDouble(sc.nextLine());
            double x2 = Double.parseDouble(sc.nextLine());
            double y2 = Double.parseDouble(sc.nextLine());

            double rectangleHeight =  Math.abs(y2 - y1);
            double rectangleWidth = Math.abs(x2 - x1);

            double rectangleArea = rectangleHeight*rectangleWidth;
            double rectanglePerimeter = 2 * (rectangleHeight + rectangleWidth);

            System.out.printf("%.2f \n%.2f", rectangleArea, rectanglePerimeter);
    }
}
