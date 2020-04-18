import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetsOfElements {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        Set<Integer> firstNumnbers = new LinkedHashSet<>();
        int firstSetLength = Integer.parseInt(tokens[0]);

        Set<Integer> secondNumbers = new LinkedHashSet<>();
        int secondSetLength = Integer.parseInt(tokens[1]);

        fillSet(firstNumnbers, firstSetLength, reader);
        fillSet(secondNumbers, secondSetLength, reader);
        Set<Integer> result = getEqualsValues(firstNumnbers, secondNumbers);
        result.forEach(element -> System.out.print(element + " "));

    }

    private static Set<Integer> getEqualsValues(Set<Integer> firstNumbers, Set<Integer> secondNumbers) {
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        for (int number : firstNumbers) {
            if (secondNumbers.contains(number)){
                result.add(number);
            }
        }

        return result;
    }

    private static void fillSet(Set<Integer> set, int setLength, BufferedReader reader) throws IOException {
        for (int i = 0; i < setLength; i++) {
            int input = Integer.parseInt(reader.readLine());
            set.add(input);
        }
    }
}
