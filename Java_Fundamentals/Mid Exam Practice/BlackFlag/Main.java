package BlackFlag;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int totalPlunderDays = Integer.parseInt(sc.nextLine());
        int dailyPlunder = Integer.parseInt(sc.nextLine());
        int expectedPlunder = Integer.parseInt(sc.nextLine());

        double totalPlunder = 0.0;
        for (int i = 1; i <= totalPlunderDays; i++) {
            totalPlunder += dailyPlunder;
            if (i % 3 == 0) {
                totalPlunder += dailyPlunder * 0.5;
            }

            if (i % 5 == 0) {
                totalPlunder = totalPlunder * 0.7;
            }
        }

        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.%n", totalPlunder);
        } else {
            double gatheredPlunderPercentage = (totalPlunder / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%c of the plunder.%n", gatheredPlunderPercentage, '%');
        }
    }
}