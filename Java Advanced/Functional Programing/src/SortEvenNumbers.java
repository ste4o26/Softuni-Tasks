import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class SortEvenNumbers {

    public static void main(String[] args) {


        Function<String, Integer> parseToInteger = e -> Integer.parseInt(e);
        Predicate<Integer> isEven = e -> e % 2 == 0;
        Function<Integer, String> intToString = e -> String.valueOf(e);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));){
            String[] numbers = bufferedReader.readLine().split(", ");
            List<String> evenNumbers = Arrays.stream(numbers)
                    .map(parseToInteger)
                    .filter(isEven)
                    .map(intToString)
                    .collect(Collectors.toList());

            String firstResult = String.join(", ", evenNumbers);
            System.out.println(firstResult);

            List<String> sortedEvenNumbers = Arrays.stream(numbers)
                    .map(parseToInteger)
                    .filter(isEven)
                    //.sorted((x, y) -> x < y ? -1 : (x.equals(y) ? 0 : -1))
                    .sorted()
                    .map(intToString)
                    .collect(Collectors.toList());

            String secondResult = String.join(", ", sortedEvenNumbers);
            System.out.println(secondResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
