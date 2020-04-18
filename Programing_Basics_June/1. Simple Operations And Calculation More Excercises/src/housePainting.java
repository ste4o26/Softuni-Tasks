import java.util.Scanner;

public class housePainting {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double houseHeight = Double.parseDouble(sc.nextLine());
        double houseLen = Double.parseDouble(sc.nextLine());
        double roofHeight = Double.parseDouble(sc.nextLine());


        double litterGreenPaint = 3.4;
        double litterRedPaint = 4.3;

        double doorArea = 1.2 * 2;
        double totalWindowsArea = 2 * (1.5 * 1.5);

        double totalSquareArea = 2 * (houseHeight * houseHeight) - doorArea;
        double totalRectangleArea = 2 * (houseHeight * houseLen) - totalWindowsArea;
        double totalGreenPaintedArea = totalRectangleArea + totalSquareArea;

        double totalTriangleRoofArea = 2 * ((houseHeight * roofHeight) / 2);
        double totalRectangleRoofArea = 2 * (houseHeight * houseLen);
        double totalRedPaintedArea = totalTriangleRoofArea + totalRectangleRoofArea;

        double totalGreenPaintNeeded = totalGreenPaintedArea / litterGreenPaint;
        double totalRedPaintNeeded = totalRedPaintedArea / litterRedPaint;

        System.out.printf("%.2f\n%.2f", totalGreenPaintNeeded, totalRedPaintNeeded);
    }
}
