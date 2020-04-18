import java.util.Scanner;

public class AverageNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double sum = 0.0;
        double average = 0.0;
        int counter = 1;
        int number = 0;

        for (int i = 0; i < n; i++) {
            number = Integer.parseInt(sc.nextLine());
            sum += number;

        }

        average = sum / n;
        System.out.printf("%.2f", average);
    }

}

