import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class FixEmails {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> userEmail = new LinkedHashMap<>();

        Predicate<String> isUnValidDomain = str -> {
            String[] tokens = str.split("\\.");
            if (tokens[1].equals("uk")
                    || tokens[1].equals("us")
                    || tokens[1].equals("com")) {
                return false;
            }else {
                return true;
            }
        };

        String inputLine = reader.readLine();
        while (!"stop".equals(inputLine)) {
            String name = inputLine;
            String email = reader.readLine();
            userEmail.put(name, email);

            inputLine = reader.readLine();
        }

        userEmail.entrySet()
                .stream()
                .filter(entry -> isUnValidDomain.test(entry.getValue()))
                .forEach(entry -> System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue()));
    }
}
