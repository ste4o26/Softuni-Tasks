import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fixing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] weekdays = new String[5];
        weekdays[0] = "Monday";
        weekdays[1] = "Tuesday";
        weekdays[2] = "Wednesday";
        weekdays[3] = "Thursday";
        weekdays[4] = "Friday";

        for (int day = 0; day <= weekdays.length; day++) {
            try {
                System.out.println(weekdays[day]);
            } catch (ArrayIndexOutOfBoundsException iob) {
                System.out.println("Index out of Bounds for index: " + day);
            }
        }

        reader.readLine();
    }
}
