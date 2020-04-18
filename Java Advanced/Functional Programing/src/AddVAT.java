import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddVAT {

    public static void main(String[] args) {
        Function<String, Double> parseToInteger = e -> Double.parseDouble(e);
        Function<Double, Double> addVat = e -> e * 1.20;

        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));) {
            String[] inputPrices = bf.readLine().split(",\\s+");
            List<Object> result = Arrays.stream(inputPrices)
                    .map(parseToInteger)
                    .map(addVat)
                    .collect(Collectors.toList());

            System.out.println("Prices with VAT:");
            result.forEach(e -> System.out.printf("%.2f%n", e));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
