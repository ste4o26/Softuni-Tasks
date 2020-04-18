import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareRoot {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            double poweredNumber = getSquareOfANumber(reader);
            System.out.println(poweredNumber);
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid number");
        } catch (IllegalArgumentException iae) {
            //dobra praktika e da prenasochvam err saobshteniqta da gi vkarvam v log file pyk normalnite mesigi da si prodyljat
            System.err.println("Error: " + iae.getMessage());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            System.out.println("Good bye");
        }
    }

    private static double getSquareOfANumber(BufferedReader reader) throws IOException {
        int number = Integer.parseInt(reader.readLine());
        if (number < 0) {
            throw new IllegalArgumentException("Square for negative numbers is undefined!");
        }
        double poweredNumber = Math.pow(number, 2);
        return poweredNumber;
    }
}
