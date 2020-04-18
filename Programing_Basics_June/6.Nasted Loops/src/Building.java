import java.util.Scanner;

public class Building {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int etajiQuantity = Integer.parseInt(sc.nextLine());
        int apartmentsQuantity = Integer.parseInt(sc.nextLine());

        for (int floor = etajiQuantity; floor >= 1; floor--) {

            if (floor % 2 == 0) {
                for (int office = 0; office < apartmentsQuantity; office++) {
                    if (floor == etajiQuantity) {
                        System.out.printf("L%d%d ", floor, office);
                    } else {
                        System.out.printf("O%d%d ", floor, office);
                    }
                }
            } else {
                for (int apartment = 0; apartment < apartmentsQuantity; apartment++) {
                    if (floor == etajiQuantity) {
                        System.out.printf("L%d%d ", floor, apartment);
                    } else {
                        System.out.printf("A%d%d ", floor, apartment);
                    }
                }
            }
            System.out.println();
        }
    }
}
