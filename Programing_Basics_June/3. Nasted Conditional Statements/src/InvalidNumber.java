import java.util.Scanner;

public class InvalidNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());

        boolean isValidNumber = number == 0 || (number >= 100 && number <= 200);

        if(!isValidNumber){
            System.out.println("invalid");
        }
    }
}
