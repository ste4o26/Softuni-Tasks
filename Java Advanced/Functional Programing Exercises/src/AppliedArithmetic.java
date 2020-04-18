import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class AppliedArithmetic {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BiConsumer<List<Integer>, String> updateListByCommand = (listOfNumbers, command) -> {
            for (int i = 0; i < listOfNumbers.size(); i++) {
                int currentNumber = listOfNumbers.get(i);

                switch (command) {
                    case "add":
                        listOfNumbers.set(i, currentNumber + 1);
                        break;
                    case "multiply":
                        listOfNumbers.set(i, currentNumber * 2);
                        break;
                    case "subtract":
                        listOfNumbers.set(i, currentNumber - 1);
                        break;
                }
            }
        };

        Consumer<Integer> printElement = e -> System.out.print(e + " ");

        String command = reader.readLine();
        while (!"end".equals(command)) {
            updateListByCommand.accept(numbers, command);

            command = reader.readLine();
        }

        numbers.forEach(printElement);

    }
}
