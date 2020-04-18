import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Phonebook {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Map<String, String> phoneBook = new LinkedHashMap<>();
        while (!"search".equals(input)){
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phoneNumber = tokens[1];
            phoneBook.put(name, phoneNumber);

            input = reader.readLine();
        }

        input = reader.readLine();
        while (!"stop".equals(input)){
            String result = null;
            if (phoneBook.containsKey(input)){
                result = String.format("%s -> %s", input, phoneBook.get(input));
            }else {
                result = String.format("Contact %s does not exist.", input);
            }
            System.out.println(result);

            input = reader.readLine();
        }
    }
}
