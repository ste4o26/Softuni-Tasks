import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class SumNumbers {

    public static void main(String[] args) {

        Function<String, Integer> parseToInteger = Integer::parseInt;
        BinaryOperator<Integer> sum = (e1, e2) -> e1 + e2;

        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));) {
            String numbersAsStrings = bf.readLine();
            String[] tokens = numbersAsStrings.split(", ");
            int sumOfAllNumbers = Arrays.stream(tokens)
                    .map(parseToInteger)
                    .reduce(0, sum);

            System.out.printf("Count = %d%n", tokens.length);
            System.out.printf("Sum = %d%n", sumOfAllNumbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
