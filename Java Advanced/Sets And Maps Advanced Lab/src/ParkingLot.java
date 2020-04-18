import java.util.*;

public class ParkingLot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Set<String> parkingLot = new HashSet<>();
        String input = sc.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split(",\\s+");
            String command = tokens[0];
            String carNumber = tokens[1];

            switch (command) {
                case "IN":
                    parkingLot.add(carNumber);
                    break;

                case "OUT":
                    parkingLot.remove(carNumber);
                    break;
            }
            input = sc.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parkingLot.forEach(System.out::println);
        }
    }
}
