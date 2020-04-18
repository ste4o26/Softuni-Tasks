import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionDemo {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean isNotSuccessful = true;
        String input = reader.readLine();
        while (isNotSuccessful) {

            try {
                int number = Integer.parseInt(input);
                System.out.println("You have successfully entered the number: " + number);
                isNotSuccessful = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Your input data was incorrect please try again!");
            }

            input = reader.readLine();
        }
    }
}
