import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ReverseAndExclude {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BiPredicate<Integer, Integer> removeNumbersDivisibleByN = (number, numberToDivideWith) -> number % numberToDivideWith != 0;
        Consumer<Integer> printNumber = number -> System.out.print(number + " ");

        int n = Integer.parseInt(reader.readLine());
        numbers = numbers
                .stream()
                .filter(number -> removeNumbersDivisibleByN.test(number, n))
                .collect(Collectors.toList());

        Collections.reverse(numbers);
        numbers.forEach(printNumber);

    }
}
