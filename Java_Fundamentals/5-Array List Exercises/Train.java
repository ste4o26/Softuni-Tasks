import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Train {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacityOfWagon = Integer.parseInt(sc.nextLine());

        passengersAdding(wagons, maxCapacityOfWagon, sc);
        printList(wagons);
    }

    static void passengersAdding(List<Integer> wagons, int maxCapacity, Scanner sc) {

        String[] input = sc.nextLine().split("\\s+");

        while (!input[0].equalsIgnoreCase("end")) {
            String command = input[0];

            int numberOfPassengers = 0;
            switch (command) {
                case "Add":
                    numberOfPassengers = Integer.parseInt(input[1]);
                    wagons.add(numberOfPassengers);
                    break;

                default:
                    numberOfPassengers = Integer.parseInt(input[0]);
                    for (int i = 0; i < wagons.size(); i++) {
                        int totalPassengers = numberOfPassengers + wagons.get(i);
                        if (totalPassengers <= maxCapacity) {
                            wagons.set(i, totalPassengers);
                            break;
                        }
                    }
                    break;
            }
            input = sc.nextLine().split("\\s+");
        }
    }

    static void printList(List<Integer> list){
        for (int element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
