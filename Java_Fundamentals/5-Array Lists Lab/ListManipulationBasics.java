import java.nio.channels.InterruptedByTimeoutException;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> listOfNumbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        manipulateList(listOfNumbers, sc);
        printList(listOfNumbers);
    }

    static void printList(List<Integer> list){
        for (int element : list) {
            System.out.print(element + " ");
        }
    }

    static void manipulateList(List<Integer> listOfNumbers, Scanner sc){
        String[] input = sc.nextLine().split("\\s+");
        while (!input[0].equalsIgnoreCase("end")){
            String command = input[0];
            int number = 0;
            int index = 0;
            switch (command){
                case"Add":
                    number = Integer.parseInt(input[1]);
                    listOfNumbers.add(number);
                    break;

                case"Remove":
                    number = Integer.parseInt(input[1]);
                    listOfNumbers.remove(Integer.valueOf(number));//ekvivalenta na tova e listOfNumber.remove((Integer) numbers);
                    break;

                case"RemoveAt":
                    index = Integer.parseInt(input[1]);
                    listOfNumbers.remove(index);
                    break;

                case"Insert":
                    number = Integer.parseInt(input[1]);
                    index = Integer.parseInt(input[2]);
                    listOfNumbers.add(index, number);
                    break;
            }

            input = sc.nextLine().split("\\s+");
        }
    }
}
