import java.util.Scanner;

public class DevideWithoutReminder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        double p1 = 0;
        double p2 = 0;
        double p3 = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(sc.nextLine());

            if(number % 4 == 0){
                p3++;

            }
            if(number % 3 == 0){
                p2++;

            }
            if(number % 2 == 0){
                p1++;

            }
        }

        p1 = p1 / n * 100;
        p2 = p2 / n * 100;
        p3 = p3 / n * 100;

        System.out.printf("%.2f%c%n", p1, '%');
        System.out.printf("%.2f%c%n", p2, '%');
        System.out.printf("%.2f%c%n", p3, '%');

    }
}
