import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateForNames {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lengthToCompareWith = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split("\\s+");

        BiPredicate<String, Integer> isNameInLength = (name, length) -> name.length() <= length;

        Arrays.stream(names)
                .filter(name -> isNameInLength.test(name, lengthToCompareWith))
                .forEach(System.out::println);

    }
}
