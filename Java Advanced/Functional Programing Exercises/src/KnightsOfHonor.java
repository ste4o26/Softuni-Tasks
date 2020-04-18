import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Consumer;

public class KnightsOfHonor {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        List<String> names = List.of(input.split("\\s+"));

        Consumer<String> printNamesWithTitle = name -> System.out.println("Sir " + name);

        names
                .forEach(printNamesWithTitle);
    }
}
