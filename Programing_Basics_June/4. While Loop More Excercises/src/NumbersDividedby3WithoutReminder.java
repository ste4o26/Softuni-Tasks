import java.util.Scanner;

public class NumbersDividedby3WithoutReminder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int counter = 1; counter <= 100; counter++) {
            if (counter % 3 == 0) {
                System.out.println(counter);
            }
        }
    }
}
