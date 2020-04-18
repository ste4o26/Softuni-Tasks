import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FindEvensOrOdds {

    public static void main(String[] args) {

        Predicate<Integer> isEvenNumber = number -> number % 2 == 0;
        Predicate<Integer> isOddNumber = number -> number % 2 != 0;

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));) {
            List<Integer> numbers = new ArrayList<>();
            fillList(numbers, bf);
            String command = bf.readLine();

            if (command.equals("even")) {
                numbers
                        .stream()
                        .filter(isEvenNumber)
                        .forEach(number -> System.out.print(number + " "));

            }else {
                numbers
                        .stream()
                        .filter(isOddNumber)
                        .forEach(number -> System.out.print(number + " "));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void fillList(List<Integer> list, BufferedReader bf){
        try {
            String[] tokens = bf.readLine().split("\\s+");
            int lowerBound = Integer.parseInt(tokens[0]);
            int upperBound = Integer.parseInt(tokens[1]);
            for (int i = lowerBound; i <= upperBound; i++) {
                list.add(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
