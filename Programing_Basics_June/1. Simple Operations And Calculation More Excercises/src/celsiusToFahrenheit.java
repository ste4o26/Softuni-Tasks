import java.util.Scanner;

public class celsiusToFahrenheit {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double celsiusDegrees = Double.parseDouble(sc.nextLine());

        double fahrenheitDegrees = celsiusDegrees * 1.8 + 32;

        System.out.printf("%.2f", fahrenheitDegrees);
    }
}
