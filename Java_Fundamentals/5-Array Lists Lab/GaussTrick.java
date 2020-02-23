import java.util.*;
import java.util.stream.Collectors;

public class GaussTrick {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        List<Long> listOfNumbers = Arrays.stream(input.split("\\s+"))
                .map(Long::parseLong)
                .collect(Collectors.toList()); //shortcut vmesto da zapisvam vhoda v array purvo i posle s for
        // cikyl da go obhojdam i da dobavqm kam lista taka vsichko se zapisva direktno v lista


        sumFirstAndLastNumbers(listOfNumbers);
    }

    static void sumFirstAndLastNumbers(List<Long> listOfNumbers) {
        for (int i = 0; i < listOfNumbers.size() - 1; i++) {
            long currentSum = listOfNumbers.get(i) + listOfNumbers.get(listOfNumbers.size() - 1);
            listOfNumbers.set(i, currentSum);
            listOfNumbers.remove(listOfNumbers.size() - 1);

        }

        printList(listOfNumbers);
    }

    static void printList(List<Long> listOfNumbers) {
        for (long element : listOfNumbers) {
            System.out.print(element + " ");
        }
    }
}
