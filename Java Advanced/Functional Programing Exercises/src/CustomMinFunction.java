import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class CustomMinFunction {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Integer[] numbers = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Function<Integer[], Integer> getMinValue = array -> {
            int minValue = Integer.MAX_VALUE;
            for (int currentNumber : array) {
                if (currentNumber < minValue) {
                    minValue = currentNumber;
                }
            }

            return minValue;
        };

        Integer minValue = getMinValue.apply(numbers);
        System.out.println(minValue);
    }
}
