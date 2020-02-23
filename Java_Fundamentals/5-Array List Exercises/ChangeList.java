import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ChangeList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> listOfNumbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        manipulatingList(listOfNumbers, sc);
        printList(listOfNumbers);
    }

    static void manipulatingList(List<Integer> listOfNumbers, Scanner sc){
        String[] input = sc.nextLine().split("\\s+");

        while (!input[0].equalsIgnoreCase("end")){
            String command = input[0];
            int element = 0;
            int index = 0;
            switch (command){
                case "Insert":
                    element = Integer.parseInt(input[1]);
                    index = Integer.parseInt(input[2]);
                    listOfNumbers.add(index, element);
                    break;

                case "Delete":
                    element = Integer.parseInt(input[1]);
                    while (listOfNumbers.remove(Integer.valueOf(element))); //-> taka iztrivam vsichki elementi s posochenata stoinost
                    //listOfNumbers.remove(Integer.valueOf(element)); //-> taka iztrivam 1 element s posochenata stoinost
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
// TO DO!!!