import java.util.Scanner;

public class NumberInRange1To100 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());

        while (number < 1 || number > 100){
            System.out.println("Invalid number!");

            number = Integer.parseInt(sc.nextLine());
        }

        System.out.println("The number is:" + number);
    }
}
