import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {

    public static void main(String[] args) {
        Predicate<String> isStartingWithUppercase = e -> Character.isUpperCase(e.charAt(0)) || Character.isDigit(e.charAt(0));

        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));){
            String[] text = bf.readLine().split("\\s+");
            List<String> result = Arrays.stream(text)
                    .filter(isStartingWithUppercase)
                    .collect(Collectors.toList());

            System.out.println(result.size());
            result.forEach(e -> System.out.println(e));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
