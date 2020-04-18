import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class FindTheSmallestElement {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Function<Integer[], Integer> getSmallestElementIndex = array -> {
            int smallestElement = array[0];
            int bestIndex = 0;
            for (int i = 1; i < array.length; i++) {
                if (array[i] <= smallestElement){
                    smallestElement = array[i];
                    bestIndex = i;
                }
            }
            return bestIndex;
        };

        Integer bestIndex = getSmallestElementIndex.apply(numbers);
        System.out.println(bestIndex);
    }
}
