import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int start = Integer.parseInt(reader.readLine());
            int end = Integer.parseInt(reader.readLine());
            try {
                printNumbers(start, end);
                break;
            } catch (IllegalArgumentException iae) {
                System.out.println("Invalid Numbers Have Been Entered Please Try again");
            }
        }


    }

    private static void printNumbers(int start, int end) {
        if (!(isNumberInRange(start) && isNumberInRange(end))) {
            throw new IllegalArgumentException();
        }

        for (int number = start; number <= end; number++) {
            System.out.println(number);
        }
    }

    private static boolean isNumberInRange(int number) {
        return number >= 1 && number <= 100;
    }
}
