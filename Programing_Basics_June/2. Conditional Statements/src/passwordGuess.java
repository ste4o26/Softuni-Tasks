import java.util.Scanner;

public class passwordGuess {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String pass = sc.nextLine();
        boolean isPassCorrect = pass.equals("s3cr3t!P@ssw0rd");

        if(isPassCorrect){
            System.out.println("Welcome");

        }else {
            System.out.println("Wrong password!");
        }
    }
}
