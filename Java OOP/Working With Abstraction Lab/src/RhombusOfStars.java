import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RhombusOfStars {

    private static final String STAR = "*";
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for (int starsCounter = 1; starsCounter < n; starsCounter++) {
            printRow(starsCounter, n);
        }

        for (int starsCounter = n; starsCounter >= 1; starsCounter--) {
            printRow(starsCounter, n);
        }
    }

    private static void printRow(int starsCounter, int n) {
        printSpaces(starsCounter, n);
        for (int i = 0; i < starsCounter; i++) {
            System.out.print(STAR + SPACE);
        }
        System.out.println();
    }

    private static void printSpaces(int starsCounter, int n) {
        for (int i = 0; i < n - starsCounter; i++) {
            System.out.print(SPACE);
        }
    }
}
