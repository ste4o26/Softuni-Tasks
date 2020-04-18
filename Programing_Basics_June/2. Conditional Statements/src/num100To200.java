import java.util.Scanner;

public class num100To200 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());

        boolean isNumLessThan100 = number < 100;
        boolean isNumBetween100and200 = number >= 100 && number <= 200;
        boolean isNumGreaterThan200 = number > 200;

        if(isNumLessThan100){
            System.out.println("Less than 100");

        }else if(isNumBetween100and200){
            System.out.println("Between 100 and 200");

        }else if(isNumGreaterThan200){
            System.out.println("Greater than 200");

        }
    }
}
