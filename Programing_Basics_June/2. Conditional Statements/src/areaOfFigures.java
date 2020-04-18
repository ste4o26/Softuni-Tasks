import java.util.Scanner;

public class areaOfFigures {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String figure = sc.nextLine();

        boolean isfigureSquare = figure.equals("square");
        boolean isFigureRectangle = figure.equals("rectangle");
        boolean isFigureCircle = figure.equals("circle");
        boolean isFigureTriangle = figure.equals("triangle");

        if(isfigureSquare){
            double squareSide = Double.parseDouble(sc.nextLine());
            double squareArea = squareSide * squareSide;
            System.out.printf("%.3f", squareArea);

        }else if(isFigureRectangle){
            double rectangleLen = Double.parseDouble(sc.nextLine());
            double rectangleWidth = Double.parseDouble(sc.nextLine());
            double rectangleArea = rectangleLen * rectangleWidth;
            System.out.printf("%.3f", rectangleArea);

        }else if(isFigureCircle){
            double circleRadius = Double.parseDouble(sc.nextLine());
            double circleArea = Math.PI * circleRadius * circleRadius;
            System.out.printf("%.3f", circleArea);

        }else if(isFigureTriangle){
            double triangleSide = Double.parseDouble(sc.nextLine());
            double trianlgeHeight = Double.parseDouble(sc.nextLine());
            double triangleArea = triangleSide * trianlgeHeight / 2;
            System.out.printf("%.3f", triangleArea);

        }
    }
}
