import java.util.Scanner;

public class greaterNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstNum = Integer.parseInt(sc.nextLine());
        int secondNum = Integer.parseInt(sc.nextLine());
        boolean isFirstNumGreater = firstNum > secondNum;

        if(isFirstNumGreater){
            System.out.println(firstNum);

        }else {
            System.out.println(secondNum);

        }
    }
}
