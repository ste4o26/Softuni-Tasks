import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class ListOfPredicates {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Predicate<Integer> isDivisibleBy = number -> {
            for (int numberToDivideWith : numbers) {
                if (number % numberToDivideWith != 0){
                    return false;
                }
            }
            return true;
        };

        for (int currentNumber = 1; currentNumber <= n; currentNumber++) {
            if (isDivisibleBy.test(currentNumber)){
                System.out.print(currentNumber + " ");
            }
        }
    }
}
