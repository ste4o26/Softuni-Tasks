import java.util.Scanner;

public class PointOnRectangleBorder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //read input
        //check if point coordinates are equils to x or y and if they print border
        //otherwise prin inside / outside
        //x1 < x2 && y1 < y2

        double x1 = Double.parseDouble(sc.nextLine());
        double y1 = Double.parseDouble(sc.nextLine());
        double x2 = Double.parseDouble(sc.nextLine());
        double y2 = Double.parseDouble(sc.nextLine());

        double x = Double.parseDouble(sc.nextLine());
        double y = Double.parseDouble(sc.nextLine());

        boolean isPointOnXBetweenY = (x == x1 || x == x2) && (y >= y1 && y <= y2);
        boolean isPointOnYBetweenX = (y == y1 || y == y2) && (x >= x1 && x <= x2);

        if(isPointOnXBetweenY || isPointOnYBetweenX){
            System.out.println("Border");

        }else {
            System.out.println("Inside / Outside");
        }
    }
}
