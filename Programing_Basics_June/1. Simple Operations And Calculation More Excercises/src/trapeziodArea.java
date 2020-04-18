import java.util.Scanner;

public class trapeziodArea {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double trapeziodBasisA = Double.parseDouble(sc.nextLine());
        double trapeziodBasisB = Double.parseDouble(sc.nextLine());
        double trapeziodHeigh = Double.parseDouble(sc.nextLine());


        double trapeziodArea = ((trapeziodBasisA + trapeziodBasisB) * trapeziodHeigh) / 2;

        System.out.printf("%.2f", trapeziodArea);
    }
}
