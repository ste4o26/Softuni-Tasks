import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class AMinerTask {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        Map<String, Integer> resourcesQuantity = new LinkedHashMap<>();

        while (!"stop".equals(inputLine)) {
            String resource = inputLine;
            int quantity = Integer.parseInt(reader.readLine());
            if (!resourcesQuantity.containsKey(resource)) {
                resourcesQuantity.put(resource, quantity);
            } else {
                int newQuantity = resourcesQuantity.get(resource) + quantity;
                resourcesQuantity.put(resource, newQuantity);
            }

            inputLine = reader.readLine();
        }

        resourcesQuantity.forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));
    }
}
